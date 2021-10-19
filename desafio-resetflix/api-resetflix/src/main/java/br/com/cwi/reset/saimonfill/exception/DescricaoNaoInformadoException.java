package br.com.cwi.reset.saimonfill.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DescricaoNaoInformadoException extends CampoNaoInformadoException {
    public DescricaoNaoInformadoException() {
        super("descricao");
    }
}
