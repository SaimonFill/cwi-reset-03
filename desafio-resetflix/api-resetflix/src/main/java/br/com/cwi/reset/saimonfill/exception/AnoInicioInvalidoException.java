package br.com.cwi.reset.saimonfill.exception;

public class AnoInicioInvalidoException extends Exception{
    public AnoInicioInvalidoException(String tipoProfissao) {
        super(String.format("Ano de início de atividade inválido para o %s cadastrado.", tipoProfissao));
    }
}