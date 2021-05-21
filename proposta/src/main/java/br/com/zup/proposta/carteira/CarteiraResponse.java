package br.com.zup.proposta.carteira;

import javax.validation.constraints.NotBlank;

import br.com.zup.proposta.cartao.CartaoModel;

public class CarteiraResponse {
	
	private String resultado;
	private @NotBlank String id;
	
	public CarteiraResponse(String resultado, @NotBlank String id) {
		
		this.resultado = resultado;
		this.id = id;
	}

	public String getResultado() {
		return resultado;
	}

	public String getId() {
		return id;
	}

	public CarteiraModel toModel(CarteiraRequest request, CartaoModel cartao) {
    	return new CarteiraModel(id, request.getEmail(), request.getCarteira(), cartao);
    }
	
	
}
