package br.com.zup.proposta.biometria;

import java.util.Optional;
import javax.transaction.Transactional;
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
import org.springframework.web.util.UriComponentsBuilder;
import br.com.zup.proposta.cartao.CartaoModel;
import br.com.zup.proposta.cartao.CartaoRepository;
import br.com.zup.proposta.compartilhado.ExecutorTransacao;
import java.net.URI;

@RestController
@RequestMapping("/biometria")
public class CadastroBiometriaController {
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Autowired
	private ExecutorTransacao executorTransacao;
	
	private final Logger logger = LoggerFactory.getLogger(CadastroBiometriaController.class);
	
	@PostMapping("/{id}")
    @Transactional
    public ResponseEntity<?> salvarBiomatria(@PathVariable("id") Long id,
                                             @RequestBody @Valid CadastroBiometriaRequest request,
                                             UriComponentsBuilder uriBuilder  ){
		Optional<CartaoModel> cartao = cartaoRepository.findById(id);
		if(!cartao.isPresent()) {
			logger.warn("Cartão não identificado");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id);
		}
		
		CadastroBiometriaModel biometria = request.toModel(cartao);
		executorTransacao.salvaEComita(biometria);
		logger.info("Biometria cadastrada {}", cartao.get().getId());
		URI uri = uriBuilder.path("/biometria/{id}").build(biometria.getId());
		return ResponseEntity.created(uri).build();
	}
 
}
