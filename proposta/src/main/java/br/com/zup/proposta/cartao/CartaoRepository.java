package br.com.zup.proposta.cartao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartaoRepository extends JpaRepository<CartaoModel, String>{
	 Optional<CartaoModel> findByPropostaId(Long propostaId);
}




