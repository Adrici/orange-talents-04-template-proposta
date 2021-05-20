package br.com.zup.proposta.viagem;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

import com.sun.istack.NotNull;

import br.com.zup.proposta.cartao.CartaoModel;

@Entity
public class AvisoViagemModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String destino;
	
	@NotNull
	@CreationTimestamp
	private LocalDateTime instanteAvisoViagem = LocalDateTime.now();
	
	@NotNull
	@Future
	private LocalDate dataTerminoViagem;
	
	@NotBlank
	private String ipCliente;
	@NotBlank
	private String userAgent;
	
	@NotNull
	@ManyToOne()
	private CartaoModel cartao;


	
	
	public AvisoViagemModel(@NotBlank String destino, @Future LocalDate dataTerminoViagem, @NotBlank String ipCliente,
			@NotBlank String userAgent, CartaoModel cartao) {

		this.destino = destino;
		this.dataTerminoViagem = dataTerminoViagem;
		this.ipCliente = ipCliente;
		this.userAgent = userAgent;
		this.cartao = cartao;
	}



	@Deprecated 
	public AvisoViagemModel() 
	{}



	public Long getId() {
		return id;
	}



	public String getDestino() {
		return destino;
	}



	public LocalDateTime getInstanteAvisoViagem() {
		return instanteAvisoViagem;
	}



	public LocalDate getDataTerminoViagem() {
		return dataTerminoViagem;
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
