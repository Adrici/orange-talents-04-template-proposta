package br.com.zup.proposta.cartao;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import br.com.zup.proposta.bloqueio.BloqueioRequest;
import br.com.zup.proposta.viagem.AvisoViagemRequest;

@FeignClient(value = "cartao", url = "${cartao.host}")
@Component
public interface CartaoClienteFeing {

    @GetMapping("/api/cartoes?idProposta")
    public CartaoResponse consultaCartao(@RequestParam("idProposta") Long idProposta);
    
    @PostMapping("/{id}/bloqueios") 
    public void bloqueioCartao(@PathVariable String id, @RequestBody @Valid BloqueioRequest request);
    
   //Usando o Feing para notificar o sistema bancário sobre avisarViagem 
    @PostMapping("/{id}/avisos") 
    public void avisarViagem(@PathVariable String id, @RequestBody @Valid AvisoViagemRequest request);
   
}  