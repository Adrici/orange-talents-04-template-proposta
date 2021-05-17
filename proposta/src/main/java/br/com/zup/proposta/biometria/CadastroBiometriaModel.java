package br.com.zup.proposta.biometria;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	private String fingerPrint;
	
	@NotNull
	@ManyToOne
	private CartaoModel cartao;
	
	@NotNull
	@CreationTimestamp
	private LocalDateTime cadastradaEm = LocalDateTime.now();
	
	@Deprecated
	public CadastroBiometriaModel() {
		
	}

	public CadastroBiometriaModel(Long id, @NotNull String fingerPrint, @NotNull CartaoModel cartao,
			@NotNull LocalDateTime cadastradaEm) {
		super();
		this.id = id;
		this.fingerPrint = fingerPrint;
		this.cartao = cartao;
		this.cadastradaEm = cadastradaEm;
	}

	public Long getId() {
		return id;
	}

	public String getFingerPrint() {
		return fingerPrint;
	}

	public CartaoModel getCartao() {
		return cartao;
	}

	public LocalDateTime getCadastradaEm() {
		return cadastradaEm;
	}

	

}
