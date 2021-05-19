package br.com.zup.proposta.bloqueio;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

import com.sun.istack.NotNull;

import br.com.zup.proposta.cartao.CartaoModel;

@Entity
public class BloqueioModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@CreationTimestamp
	private LocalDateTime instanteBloqueio = LocalDateTime.now();
	@NotBlank
	private String ipCliente;
	@NotBlank
	private String userAgent;
	@NotNull
	@OneToOne
	private CartaoModel cartao;
	public BloqueioModel(Long id, LocalDateTime instanteBloqueio, @NotBlank String ipCliente,
			@NotBlank String userAgent, CartaoModel cartao) {

		this.ipCliente = ipCliente;
		this.userAgent = userAgent;
		this.cartao = cartao;
	}
	@Deprecated
	public BloqueioModel() {}
	
	
	public Long getId() {
		return id;
	}
	public LocalDateTime getInstanteBloqueio() {
		return instanteBloqueio;
	}
	public String getIpCliente() {
		return ipCliente;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public CartaoModel getCartao() {
		return cartao;
	}
	
	
}
