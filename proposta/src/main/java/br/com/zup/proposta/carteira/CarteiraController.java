package br.com.zup.proposta.carteira;

import java.net.URI;
import java.util.Optional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.zup.proposta.cartao.CartaoClienteFeing;
import br.com.zup.proposta.cartao.CartaoModel;
import br.com.zup.proposta.cartao.CartaoRepository;
import br.com.zup.proposta.compartilhado.ExecutorTransacao;
import feign.FeignException;

@RestController
@RequestMapping("/carteira")
public class CarteiraController {
	
	@Autowired
    private CartaoRepository cartaoRepository;
	@Autowired
	private CarteiraRepository carteiraRepository;
	
	@Autowired
	private CartaoClienteFeing cartaoClienteFeing;
	@Autowired
	private ExecutorTransacao executorTransacao;


	private final Logger logger = LoggerFactory.getLogger(CarteiraController.class);
	
	
	@PostMapping("/{idCartao}")
	public ResponseEntity<?> associarCarteira(@PathVariable("idCartao") String id,
												@RequestBody @Valid CarteiraRequest request,
												UriComponentsBuilder uriBuilder){
		Optional<CartaoModel> cartao = cartaoRepository.findById(id);
        if(cartao.isEmpty()){
        	logger.warn("Cartão {} inexistente=", id);
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cartão inexistente=");
        }
        
      if(carteiraRepository.existsByCartaoAndCarteira(cartao.get(), request.getCarteira())) {
        	logger.warn("Cartão já associado");
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cartão foi associado à uma cateira");
        }
		CarteiraModel carteiraCriada = associarCartao(cartao.get(), request);
		URI uri = uriBuilder.path("/carteiras/{id}").build(carteiraCriada.getId());
		return ResponseEntity.created(uri).build();
	} 

	public CarteiraModel associarCartao(CartaoModel cartao, CarteiraRequest request) {
		try {
			CarteiraResponse carteiraResponse = cartaoClienteFeing.associarCarteira(cartao.getId(), request);
			CarteiraModel novaCarteira = carteiraResponse.toModel(request, cartao);
			executorTransacao.salvaEComita(novaCarteira);
			return novaCarteira;
		} catch (FeignException.UnprocessableEntity e) {
			logger.error(" Erro = {}", e.toString());
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"Falha ao tentar associar o cartão");
		}
	}
	
}
