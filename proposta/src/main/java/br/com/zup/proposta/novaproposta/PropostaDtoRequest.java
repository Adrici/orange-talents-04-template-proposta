package br.com.zup.proposta.novaproposta;


import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import br.com.zup.proposta.compartilhado.CpfOrCnpj;
import br.com.zup.proposta.compartilhado.UniqueValue;

public class PropostaDtoRequest {
	
	@NotBlank
	@CpfOrCnpj
	@UniqueValue(targetClass = PropostaModel.class, campo = "documento")
	private String documento;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String endereco;
	
	@NotNull
	@Positive
	private BigDecimal salario;

	public PropostaDtoRequest(@NotBlank String documento, @NotBlank @Email String email, @NotBlank String nome,
			@NotBlank String endereco, @NotNull @Positive BigDecimal salario) {
		
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
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
	
	 public PropostaModel toModel(){
	        return new PropostaModel(null, documento, email, nome, endereco, salario);
	    }
	
	
/*A proposta deve estar armazenada no sistema, 
 * com um identificador gerado pelo sistema.
Retornar 201 com Header Location preenchido com a URL da nova 
proposta em caso de sucesso.
Retornar 400 quando violado alguma das restrições.*/
	//FAZER O MÉTODO PARA ISSO COM A PERSISTENCIA ....

}
