package br.com.zup.proposta.cartao;
import java.time.LocalDateTime;

import br.com.zup.proposta.novaproposta.PropostaModel;


public class CartaoResponse {

    private Long id;
    private String titular;
    private LocalDateTime emitidoEm; 
    private Integer limite;
    private String idProposta;

   
	 public CartaoResponse(Long id, String titular, LocalDateTime emitidoEm, Integer limite, String idProposta) { 
		this.id = id;
		this.titular = titular;
		this.emitidoEm = emitidoEm;
		this.limite = limite;
		this.idProposta = idProposta;
	}

		 
	public Long getId() {
		return id;
	}

	public String getTitular() {
		return titular;
	}

	public LocalDateTime getEmitidoEm() {
		return emitidoEm;
	}

	public Integer getLimite() {
		return limite;
	}


	public String getIdProposta() {
		return idProposta;
	}


	public CartaoModel toModel(PropostaModel proposta){
	        return new  CartaoModel(emitidoEm, titular, idProposta, limite, proposta);  
	    }

	@Override
    public String toString() {
        return "CartaoResponse{" +
                "id='" + id + '\'' +
                ", titular='" + titular + '\'' +
                ", emitidoEm=" + emitidoEm +
                ", limite=" + limite +
                ", idProposta='" + idProposta + '\'' +
                '}';
    }
}
