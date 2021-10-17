package br.com.cwi.reset.saimonfill.model;

import java.time.LocalDate;

public class Diretor {

    private Integer id = 0;
    private String nome;
    private LocalDate dataNascimento;
    private Integer anoInicioAtividade;

    public Diretor(String nome, LocalDate dataNascimento, Integer anoInicioAtividade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.anoInicioAtividade = anoInicioAtividade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id += id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Diretor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", anoInicioAtividade=" + anoInicioAtividade +
                '}';
    }
}
