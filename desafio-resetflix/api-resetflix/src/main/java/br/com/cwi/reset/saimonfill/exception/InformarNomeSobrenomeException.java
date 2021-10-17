package br.com.cwi.reset.saimonfill.exception;

public class InformarNomeSobrenomeException extends Exception{
    public InformarNomeSobrenomeException(String tipoProfissao) {
        super(String.format("Deve ser informado no mínimo nome e sobrenome para o %s", tipoProfissao));
    }
}