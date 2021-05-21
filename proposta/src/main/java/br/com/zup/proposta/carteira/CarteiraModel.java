package br.com.zup.proposta.carteira;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import br.com.zup.proposta.cartao.CartaoModel;

@Entity
public class CarteiraModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@NotBlank
	private String idAssociacao;
	@NotBlank
	private String email;
	@NotNull
	
	@Enumerated(EnumType.STRING)
	private TipoCarteira carteira;
	@ManyToOne
	
	private CartaoModel cartao;
	
	//construtores
	public CarteiraModel(@NotBlank String idAssociacao, @NotBlank String email, @NotNull TipoCarteira carteira,
			CartaoModel cartao) {
		this.idAssociacao = idAssociacao;
		this.email = email;
		this.carteira = carteira;
		this.cartao = cartao;
	}
	
	@Deprecated
	public CarteiraModel() {
		
	}
	
	public String getId() {
		return id;
	}
	public String getIdAssociacao() {
		return idAssociacao;
	}
	public String getEmail() {
		return email;
	}
	public TipoCarteira getCarteira() {
		return carteira;
	}
	public CartaoModel getCartao() {
		return cartao;
	}
	
	
	
}
