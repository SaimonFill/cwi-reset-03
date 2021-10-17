package br.com.cwi.reset.saimonfill.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ListaVaziaException extends Exception{
    public ListaVaziaException(String atividade, String tipoProfissão) {
        super(String.format("Nenhum %s cadastrado, favor cadastar %s.", atividade, tipoProfissão));
    }
}