package br.com.cwi.reset.saimonfill.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NaoCadastrarNaoNacidosException extends Exception {
    public NaoCadastrarNaoNacidosException(String atividade) {
        super(String.format("Não é possível cadastrar %s não nascidos.", atividade));
    }
}