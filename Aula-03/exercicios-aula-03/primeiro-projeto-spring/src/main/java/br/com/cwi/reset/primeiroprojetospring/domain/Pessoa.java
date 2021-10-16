package br.com.cwi.reset.primeiroprojetospring.domain;

import java.time.LocalDate;
import java.time.Period;

public abstract class Pessoa {

    private String nome;
    private Integer dataNascimento;
    private Genero genero;

    public Pessoa(String nome, Integer dataNascimento, Genero genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
    }

//    public void caracteristica(){
//        System.out.print("\n" + nome + ", " + this.calcularIdade() + " anos, " + genero.getDescricao());
//    }

//    private Integer calcularIdade() {
//        return Period.between(dataNascimento, LocalDate.now()).getYears();
//    }

    public String getNome() {
        return nome;
    }

    public Integer getDataNascimento() {
        return dataNascimento;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(Integer dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
