package br.com.cwi.reset.saimonfill.exception;

public class JaExisteCadastradoException extends Exception{
    public JaExisteCadastradoException(String tipoProfissao, String nome) {
        super(String.format("Já existe um %s cadastrado para o nome %s.",tipoProfissao, nome));
    }
}