package br.com.zup.proposta.cartao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.zup.proposta.compartilhado.ExecutorTransacao;
import br.com.zup.proposta.novaproposta.PropostaRepository;
import feign.FeignException;




@Component
public class CartaoScheduler {
	
	@Autowired
	private CartaoClienteFeing cartaoClienteFeing;

	@Autowired
	private PropostaRepository propostaRepository;

	@Autowired
	private CartaoRepository cartaoRepository;


	private Logger logger = LoggerFactory.getLogger(CartaoScheduler.class);
	
	@Scheduled(fixedRateString = "${atualizacao.scheduler}")
    public void verificaSituacaoNoCartao() {
        var propostasAprovadas = propostaRepository.buscarPropostasElegiveis();

        for (var proposta : propostasAprovadas) {
            try {
                var response = cartaoClienteFeing.consultaCartao(proposta.getId());
                var cartao = response.toModel(proposta);
                cartaoRepository.save(cartao);
                
                logger.info("Cartão Salvo");            
                
            } catch (FeignException exception) {
                logger.info("Exceção: Cartao - CartaoClienteFeing");
            }
        }

    }

}
