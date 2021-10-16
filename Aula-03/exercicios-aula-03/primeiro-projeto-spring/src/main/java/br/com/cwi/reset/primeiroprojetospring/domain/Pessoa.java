package br.com.cwi.reset.primeiroprojetospring.domain;

import java.time.LocalDate;
import java.time.Period;

public abstract class Pessoa {

    private String nome;
    private LocalDate dataNascimento;
    private Genero genero;

    public Pessoa(String nome, LocalDate dataNascimento, Genero genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
    }

    public void caracteristica(){
        System.out.print("\n" + nome + ", " + this.calcularIdade() + " anos, " + genero.getDescricao());
    }

    private Integer calcularIdade() {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }
}
