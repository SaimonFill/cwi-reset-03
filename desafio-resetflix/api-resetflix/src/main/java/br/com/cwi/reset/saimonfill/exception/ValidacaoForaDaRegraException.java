package br.com.cwi.reset.saimonfill.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidacaoForaDaRegraException extends CampoNaoInformadoException {
    public ValidacaoForaDaRegraException() {
        super("Esta validação não estava nas regras.");
    }
}