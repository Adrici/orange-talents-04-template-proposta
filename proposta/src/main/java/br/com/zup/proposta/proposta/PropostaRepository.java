package br.com.zup.proposta.proposta;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PropostaRepository extends JpaRepository<PropostaModel, Long> {
	Optional<PropostaModel> findById(Long id);

}
