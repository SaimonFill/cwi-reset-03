package br.com.cwi.reset.primeiroprojetospring.domain;

public class AvaliacaoForaDoPadraoException extends Exception {

    public AvaliacaoForaDoPadraoException() {
        super("Nota inválida, deve ser entre 1 a 5");
    }
}
