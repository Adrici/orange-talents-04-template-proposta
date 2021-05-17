package br.com.zup.proposta.novaproposta;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PropostaRepository extends JpaRepository<PropostaModel, Long> {
	
	Optional<PropostaModel> findById(Long id);


	
//Para Consultas no Banco de Dados : método findById - Já existe por Default
//	Usando o Optional, porque ele pode ou nao existir, de acordo com a consulta no banco.
//Usariamos Collection caso fizemos a consulta com mais de um atributo no parâmetro - 
	//Exemplo: findByNameAndDocumento (name, documento).

} 
 