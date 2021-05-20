package br.com.zup.proposta.viagem;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
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
import br.com.zup.proposta.cartao.CartaoClienteFeing;
import br.com.zup.proposta.cartao.CartaoModel;
import br.com.zup.proposta.cartao.CartaoRepository;
import br.com.zup.proposta.compartilhado.ExecutorTransacao;


@RestController
@RequestMapping("/viagem")
public class AvisoViagemController {
	
		@Autowired
	    private CartaoRepository cartaoRepository;
		@Autowired
		private ExecutorTransacao executorTransacao;
		@Autowired
		private CartaoClienteFeing cartaoClienteFeing;
		
		private final Logger logger = LoggerFactory.getLogger(AvisoViagemController.class);

		@PostMapping("/{idCartao}")
		public ResponseEntity<?> novoAvisoViagem(@PathVariable("idCartao") String id,
				HttpServletRequest servletRequest,
				@RequestBody @Valid AvisoViagemRequest request){
			
//Armazenada no sistema, com um identificador gerado pelo sistema.
			Optional<CartaoModel> cartao = cartaoRepository.findById(id);
	        if(cartao.isEmpty()){
	        	logger.warn("Cartão {} inesxistente=", id);
	        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cartão não encontrado");
	        }
	        
//Notificando o sistema bancário - Viagem - notificando o sistema legado
	        //obs: API Especifica para o sistema bancario:
	        //http://localhost:8888/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/
	        try {
				AvisoViagemModel novoAvisoViagem = request.toModel(cartao.get(), servletRequest.getLocalAddr(), 
																servletRequest.getHeader("User-Agent"));
				cartaoClienteFeing.avisarViagem(cartao.get().getId(), request);
				cartao.get().setViagem(novoAvisoViagem);
				executorTransacao.atualizaEComita(cartao.get());
				logger.info("Viagem registrada com sucesso!");	
			} catch (Exception e) {
				logger.error("Algo de errado não está certo {}", e.toString());
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error!!");		
			} 
	        return ResponseEntity.ok().build(); 
		}

}

