package br.com.zup.proposta.compartilhado;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.springframework.security.crypto.encrypt.Encryptors;

@Converter
public class OfuscadorEncryptors implements AttributeConverter<String, String>{


//@param atributo será ofuscado (banco de dados)
//@return documento criptografado (banco de dados)

	@SuppressWarnings("deprecation")
	@Override
	public String convertToDatabaseColumn(String documento) {
		try {
           return Encryptors.queryableText("${proposta.ofuscar.dados}", "senha").encrypt(documento);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

	
// @param atributo será descompilado do banco de dados
// @return retorna ofuscado - astericos ( Exemplo nota do pix)
	
	@SuppressWarnings("deprecation")
	@Override
	public String convertToEntityAttribute(String documento) {
		try {
           return Encryptors.queryableText("${proposta.ofuscar.dados}", "senha").decrypt(documento);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }	
	}
}
