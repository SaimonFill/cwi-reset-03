package br.com.cwi.reset.saimonfill.exception;

public class ListaVaziaException extends Exception{
    public ListaVaziaException(String atividade, String tipoProfissão) {
        super(String.format("Nenhum %s cadastrado, favor cadastar %s.", atividade, tipoProfissão));
    }
}