package br.com.cwi.reset.primeiroprojetospring.domain;

import java.time.LocalDate;

public class Ator extends Pessoa{

    private Integer oscars;

    public Ator(String nome, LocalDate dataNascimento, Genero genero, Integer oscars) {
        super(nome, dataNascimento, genero);
        this.oscars = oscars;
    }

    public Integer getOscars() {
        return oscars;
    }

    public void setOscars(Integer oscars) {
        this.oscars = oscars;
    }
}
