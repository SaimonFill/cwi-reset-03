package br.com.cwi.reset.saimonfill.exception;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FiltroNomeNaoEncontradoException extends Exception {
    public FiltroNomeNaoEncontradoException(String tipoProfissao, String filtro) {
        super(String.format("%s não encontrato com o filtro %s, favor informar outro filtro.", tipoProfissao, filtro));
    }
}