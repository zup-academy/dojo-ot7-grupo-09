package br.com.zup.edu.nossositedeviagens.Common.handler;

public class ErrorRequest {

    private String campo;
    private String erro;

    public  ErrorRequest(String campo, String erro){
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }
    public String getErro() {
        return erro;
    }
}
