package br.com.zup.proposta.cartao;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.*;

import br.com.zup.proposta.novaproposta.PropostaModel;

@Entity
@Table(name ="cartao")
public class CartaoModel {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private LocalDateTime emitidoEm;
    @NotBlank
    private String titular;
    
    @NotBlank
    private String numero;
    
    @NotNull
    private Integer limite;
  
    @NotNull @OneToOne @JoinColumn(name = "proposta")
    private PropostaModel proposta;
   
   @Enumerated(value = EnumType.STRING)
    private StatusCartao status = StatusCartao.ATIVO;

    @Deprecated
    public CartaoModel() {
    }

	

	public CartaoModel(@NotNull LocalDateTime emitidoEm, @NotBlank String titular, @NotBlank String numero,
			@NotNull Integer limite, @NotNull PropostaModel proposta) {
	
		this.emitidoEm = emitidoEm;
		this.titular = titular;
		this.numero = numero;
		this.limite = limite;
		this.proposta = proposta;

	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getEmitidoEm() {
		return emitidoEm;
	}

	public String getTitular() {
		return titular;
	}

	public String getNumero() {
		return numero;
	}

	public Integer getLimite() {
		return limite;
	}

	public PropostaModel getProposta() {
		return proposta;
	}

	public StatusCartao getStatus() {
		return status;
	}

	
}
