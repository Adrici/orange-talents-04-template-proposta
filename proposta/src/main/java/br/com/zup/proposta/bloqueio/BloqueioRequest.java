package br.com.zup.proposta.bloqueio;

import javax.validation.constraints.NotBlank;

public class BloqueioRequest {
	@NotBlank
	private String sistemaResponsavel;
	
	public String getSistemaResponsavel() {
		return sistemaResponsavel;
	}
}
