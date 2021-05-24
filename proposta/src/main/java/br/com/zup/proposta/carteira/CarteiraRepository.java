package br.com.zup.proposta.carteira;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.proposta.cartao.CartaoModel;

public interface CarteiraRepository extends JpaRepository<CarteiraModel, String> {
	
	boolean existsByCartaoAndCarteira(CartaoModel cartao, TipoCarteira carteira);
	
}
