package br.com.zup.proposta.proposta;

import java.math.BigDecimal;



public class PropostaDtoResponse {
	

	private String documento;
	private String email;
	private String nome;
	private String endereco;
	private BigDecimal salario; 
	
	public PropostaDtoResponse(PropostaModel proposta) {
		super();
		this.documento = proposta.getDocumento();
		this.email = proposta.getEmail();
		this.nome = proposta.getNome();
		this.endereco = proposta.getEndereco();
		this.salario = proposta.getSalario();
	}


	public String getDocumento() {
		return documento;
	}
	public String getEmail() {
		return email;
	}
	public String getNome() {
		return nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	
	
}
