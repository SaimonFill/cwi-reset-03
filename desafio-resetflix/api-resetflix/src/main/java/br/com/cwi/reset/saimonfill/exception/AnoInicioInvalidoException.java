package br.com.cwi.reset.saimonfill.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AnoInicioInvalidoException extends Exception{
    public AnoInicioInvalidoException(String tipoProfissao) {
        super(String.format("Ano de início de atividade inválido para o %s cadastrado.", tipoProfissao));
    }
}