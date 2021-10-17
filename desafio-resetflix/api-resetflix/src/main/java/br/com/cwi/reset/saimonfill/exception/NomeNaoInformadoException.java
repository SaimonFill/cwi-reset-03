package br.com.cwi.reset.saimonfill.exception;

public class NomeNaoInformadoException extends CampoNaoInformadoException {
    public NomeNaoInformadoException() {
        super("nome");
    }
}