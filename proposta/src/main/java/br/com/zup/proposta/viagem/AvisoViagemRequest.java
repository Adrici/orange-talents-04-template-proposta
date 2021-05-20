package br.com.zup.proposta.viagem;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import br.com.zup.proposta.cartao.CartaoModel;

public class AvisoViagemRequest {
	
	@NotBlank
	private String destino;

	@Future
	private LocalDate dataTerminoViagem;

	public AvisoViagemRequest(@NotBlank String destino, @Future LocalDate dataTerminoViagem) {

		this.destino = destino;
		this.dataTerminoViagem = dataTerminoViagem;
	}

	public String getDestino() {
		return destino;
	}

	public LocalDate getDataTerminoViagem() {
		return dataTerminoViagem;
	}
	
	public AvisoViagemModel toModel(CartaoModel cartao, String ipCliente, String userAgent) {
        return new AvisoViagemModel(destino, dataTerminoViagem, ipCliente, userAgent, cartao);
	}

}
