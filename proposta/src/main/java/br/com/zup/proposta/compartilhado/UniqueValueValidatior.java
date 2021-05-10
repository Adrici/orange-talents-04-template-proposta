package br.com.zup.proposta.compartilhado;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidatior implements ConstraintValidator<UniqueValue, String> {

    private String campo;
    private Class<?> targetClass;

    private Logger logger = LoggerFactory.getLogger(UniqueValueValidatior.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        campo = constraintAnnotation.campo();
        targetClass = constraintAnnotation.targetClass();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<?> resultList = entityManager.createQuery("SELECT 1 FROM " + targetClass.getName() + " where " + campo + " = :value")
                .setParameter("value", value).getResultList();

        Assert.state(resultList.size() <= 1, "É prmitido apenas uma proposta pra este CPF/CNPJ");

        if(resultList.size() < 1) return true;

        logger.info("Tentativa de entrada de mais de uma proposa pra o mesmo CPF/CNPJ " +
                value.substring(value.length()-3) + " Tentativa de nova proposta");

        throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Já existe uma proposta pra este " + campo);
    }
}
