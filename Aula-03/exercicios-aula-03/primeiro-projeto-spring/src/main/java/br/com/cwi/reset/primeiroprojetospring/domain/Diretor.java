package br.com.cwi.reset.primeiroprojetospring.domain;

import java.time.LocalDate;

public class Diretor extends Pessoa{

    private Integer qtdFilmesDirigidos;

    public Diretor(String nome, LocalDate dataNascimento, Genero genero, Integer qtdFilmesDirigidos) {
        super(nome, dataNascimento, genero);
        this.qtdFilmesDirigidos = qtdFilmesDirigidos;
    }

    public Integer getQtdFilmesDirigidos() {
        return qtdFilmesDirigidos;
    }

    public void setQtdFilmesDirigidos(Integer qtdFilmesDirigidos) {
        this.qtdFilmesDirigidos = qtdFilmesDirigidos;
    }
}
