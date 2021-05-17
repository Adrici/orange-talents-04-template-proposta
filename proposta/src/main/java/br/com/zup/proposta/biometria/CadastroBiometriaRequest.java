package br.com.zup.proposta.biometria;

import java.util.Base64;
import java.util.Optional;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.proposta.cartao.CartaoModel;



public class CadastroBiometriaRequest {
	
	@NotNull
	private String fingerPrint;
	

	public CadastroBiometriaRequest(@NotNull @JsonProperty("fingerPrint") String fingerPrint) {
		
		this.fingerPrint = fingerPrint;
	}



	public String getFingerPrint() {
		return fingerPrint;
	}

	
	public CadastroBiometriaModel toModel(CartaoModel cartao) {
		String biometria = Base64.getEncoder().encodeToString(fingerPrint.getBytes());
		return new CadastroBiometriaModel(biometria,cartao);
		
	}

	
}
