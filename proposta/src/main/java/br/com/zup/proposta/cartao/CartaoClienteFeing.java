package br.com.zup.proposta.cartao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "cartao", url = "${cartao.host}")
@Component
public interface CartaoClienteFeing {

    @RequestMapping(method = RequestMethod.GET,  produces = "application/json")
    public CartaoResponse consultaCartao(@RequestParam("idProposta") Long idProposta);

    
    
}