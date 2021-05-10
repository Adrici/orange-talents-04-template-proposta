package br.com.zup.proposta.analise;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "analiseProposta", url = "${analise.solicitacao.url}")
public interface AnaliseClienteFeing {

    @PostMapping("/api/solicitacao")
    public AnaliseResultadoResponse analise (AnaliseSolicitacaoRequest solicitacaoRequest);
}