package br.com.zup.proposta.compartilhado;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = {})// aqui vai vazio , porque a constraint ja fazemos nas acotacoes de cpf e cnpj neste caso 
@ConstraintComposition(CompositionType.OR)
@CPF
@CNPJ
public @interface CpfOrCnpj {
	String message() default "{com.adrici.beanvalidation.uniquevalue)";
	
	Class<?>[] groups() default{};
	
	Class<? extends Payload>[] payload() default { }; 
}
//essa classe podemos fazer para qlqr anotação quando queremos validar mais de uma coisa no campo
//pode ser AND ou OR ( and = 1,1  --- or = 0, 1 ou 1,0)
