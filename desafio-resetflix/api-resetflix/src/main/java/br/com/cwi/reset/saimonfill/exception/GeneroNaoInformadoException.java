package br.com.cwi.reset.saimonfill.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GeneroNaoInformadoException extends CampoNaoInformadoException {
    public GeneroNaoInformadoException() {
        super("Deve ser informado pelo menos um gênero para o cadastro do filme.");
    }
}