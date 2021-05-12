package br.com.zup.proposta.compartilhado;

public class ValidacaoErro {

    private String campo;
    private String mensagem;

    public ValidacaoErro(String campo,String mensagem){
        this.campo = campo;
        this.campo = mensagem;
    }
    public String getCampo(){
        return campo;
    }
    public String getMensagem(){
        return mensagem;
    }
}