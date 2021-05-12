package br.com.zup.proposta.novaproposta;

public class PropostaElegivelEvent{

    PropostaModel propostaElegivel;

    public PropostaElegivelEvent(PropostaModel propostaElegivel) {
        this.propostaElegivel = propostaElegivel;
    }

    public PropostaModel getPropostaElegivel() {
        return propostaElegivel;
    }
}
