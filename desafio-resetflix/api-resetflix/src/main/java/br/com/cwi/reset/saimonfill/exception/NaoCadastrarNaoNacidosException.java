package br.com.cwi.reset.saimonfill.exception;

public class NaoCadastrarNaoNacidosException extends Exception {
    public NaoCadastrarNaoNacidosException(String atividade) {
        super(String.format("Não é possível cadastrar %s não nascidos.", atividade));
    }
}