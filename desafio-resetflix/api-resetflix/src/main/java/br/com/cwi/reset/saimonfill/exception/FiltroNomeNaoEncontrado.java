package br.com.cwi.reset.saimonfill.exception;

import java.util.Optional;

public class FiltroNomeNaoEncontrado extends Exception {
    public FiltroNomeNaoEncontrado(String tipoProfissao, Optional<String> filtro) {
        super(String.format("%s não encontrato com o filtro %s, favor informar outro filtro.", tipoProfissao, filtro));
    }
}