package br.com.zup.proposta.compartilhado;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueValueValidatior.class)
public @interface UniqueValue {
    Class<?> targetClass();
    String campo();
    String message() default "Valor repetido";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}