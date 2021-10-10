package br.com.cwi.reset.aula;

import java.time.LocalDate;

public class Diretor extends Pessoa{

    private Integer qtdFilmesDirigidos;

    public Diretor(String nome, LocalDate dataNascimento, Genero genero, Integer qtdFilmesDirigidos) {
        super(nome, dataNascimento, genero);
        this.qtdFilmesDirigidos = qtdFilmesDirigidos;
    }
}
