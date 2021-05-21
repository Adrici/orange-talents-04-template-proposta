package br.com.zup.proposta.carteira;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CarteiraRequest {
	@NotBlank
	private String email;
	@NotNull
	private TipoCarteira carteira;
	
	public CarteiraRequest(@NotBlank String email, @NotNull TipoCarteira carteira) {
	
		this.email = email;
		this.carteira = carteira;
	}

	public String getEmail() {
		return email;
	}

	public TipoCarteira getCarteira() {
		return carteira;
	}
	
	
}
