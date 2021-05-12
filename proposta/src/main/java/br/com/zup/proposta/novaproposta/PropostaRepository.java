package br.com.zup.proposta.novaproposta;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PropostaRepository extends JpaRepository<PropostaModel, Long> {
	Optional<PropostaModel> findById(Long id);
	
	@Query(value = "Select * from proposta where resultado = 'ELEGIVEL' and numero_cartao is null", nativeQuery = true)
    List<PropostaModel> buscarPropostasElegiveis();

}
