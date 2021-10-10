package br.com.cwi.reset.aula;

import java.time.LocalDate;

public class Ator extends Pessoa{

    private Integer oscars;

    public Ator(String nome, LocalDate dataNascimento, Genero genero, Integer oscars) {
        super(nome, dataNascimento, genero);
        this.oscars = oscars;
    }
}
