package br.com.zup.proposta.cartao;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.*;

import br.com.zup.proposta.bloqueio.BloqueioModel;
import br.com.zup.proposta.novaproposta.PropostaModel;
import br.com.zup.proposta.viagem.AvisoViagemModel;

@Entity
@Table(name ="cartao")
public class CartaoModel {
	
	@Id 
    private String id;
    @NotNull
    private LocalDateTime emitidoEm;
    @NotBlank
    private String titular;
    
    @NotNull
    private Integer limite;
  
    @NotNull @OneToOne @JoinColumn(name = "proposta")
    private PropostaModel proposta;
   
   @Enumerated(value = EnumType.STRING)
    private StatusCartao status = StatusCartao.ATIVO;
   
   @OneToOne(mappedBy = "cartao", cascade = CascadeType.MERGE)
   private BloqueioModel bloqueio;
   
   @OneToMany(mappedBy = "cartao", cascade = CascadeType.MERGE)
   private Set<AvisoViagemModel> viagens;
 
    @Deprecated
    public CartaoModel() {
    }	

    
 public CartaoModel(String id, @NotNull LocalDateTime emitidoEm, @NotBlank String titular,
			@NotNull Integer limite, @NotNull PropostaModel proposta) {
		
		this.id = id;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
		this.limite = limite;
		this.proposta = proposta;

	}

	public String getId() {
		return id;
	}

	public LocalDateTime getEmitidoEm() {
		return emitidoEm;
	}

	public String getTitular() {
		return titular;
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


	public boolean verificaBloqueado() {
		return this.status.equals(StatusCartao.BLOQUEADO);
	}


	public void setBloqueio(BloqueioModel bloqueio) {
		 this.bloqueio = bloqueio;
	        this.status = StatusCartao.BLOQUEADO;
		
	}


	public void setViagem(AvisoViagemModel viagem) {
		this.viagens.add(viagem);
		this.status = StatusCartao.EM_VIAGEM;
	}
}
