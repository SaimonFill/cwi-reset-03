package br.com.cwi.reset.saimonfill.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ConsultarPeloIdException extends Exception{
    public ConsultarPeloIdException(String profissional, Integer id) {
        super(String.format("Nenhum %s encontrado com o parâmetro %d, favor verifique os parâmetros informados.", profissional, id));
    }
}