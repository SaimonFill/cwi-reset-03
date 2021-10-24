package br.com.cwi.reset.saimonfill.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NaoCadastrarEstudioFuturoException extends Exception {
    public NaoCadastrarEstudioFuturoException(String tipo) {
        super(String.format("Não é possível cadastrar %s não nascidos.", tipo));
    }
}