package br.com.zup.proposta.biometria;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import br.com.zup.proposta.cartao.CartaoModel;


@Entity
@Table(name = "biometria")
public class CadastroBiometriaModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private byte[] biometria;
	
	@NotNull
	@ManyToOne
	private CartaoModel cartao;
	
	@NotNull
	@CreationTimestamp
	private LocalDateTime cadastradaEm = LocalDateTime.now();
	
	@Deprecated
	public CadastroBiometriaModel() {
		
	}

	public CadastroBiometriaModel(@NotNull byte[] biometria, @NotNull CartaoModel cartao) {
		
		this.biometria = biometria;
		this.cartao = cartao;
	}

	//construtores
	public byte[] getBiometria() {
		return biometria;
	}

	public void setBiometria(byte[] biometria) {
		this.biometria = biometria;
	}

	//getters

	public CartaoModel getCartao() {
		return cartao;
	}

	public void setCartao(CartaoModel cartao) {
		this.cartao = cartao;
	}

	
	
}
