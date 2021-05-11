package br.com.zup.proposta.novaproposta;
import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.*;

import br.com.zup.proposta.compartilhado.CpfOrCnpj;
import br.com.zup.proposta.compartilhado.UniqueValue;

@Entity
@Table
public class PropostaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@CpfOrCnpj
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
	
	@Enumerated(EnumType.STRING )
	private PropostaResultado resultado = PropostaResultado.NAO_ANALISADO;
	
	@Deprecated 
	public PropostaModel() {
		
	}

	public PropostaModel(Long id, @NotBlank String documento, @NotBlank @Email String email, @NotBlank String nome,
			@NotBlank String endereco,  @NotNull @Positive BigDecimal salario) {
		super();
		this.id = id;
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
	}

	public Long getId() {
		return id;
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

	public   BigDecimal getSalario() {
		return salario;
	}

	public PropostaResultado getResultado() {
		return resultado;
	}

	public void setResultado(PropostaResultado resultado) {
		this.resultado = resultado;
	}
	

}
