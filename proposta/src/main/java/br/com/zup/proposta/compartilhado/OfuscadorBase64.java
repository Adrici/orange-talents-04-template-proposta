package br.com.zup.proposta.compartilhado;

import java.util.Base64;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class OfuscadorBase64 implements AttributeConverter<String, String>{

//@param atributo será ofuscado (banco de dados)
//@return documento criptografado (banco de dados)
	 
	@Override
	public String convertToDatabaseColumn(String documento) {
		return Base64.getEncoder().encodeToString(documento.getBytes());
	}

//atributo será descompilado (banco de dados)
//retorna ofuscado - com asteriscos em algumas strings
//igual em notas, comprovantes etc ( exemplo - comprovante do pix)
	
	@Override
	public String convertToEntityAttribute(String documento) {
		byte[] decode = Base64.getDecoder().decode(documento.getBytes());
		String campoDecodificada = new String(decode);
		return String.format("%10s", campoDecodificada.substring(campoDecodificada.length() - 4)).replace(' ', '*');
	}
	
}