package br.com.cwi.reset.saimonfill;

import java.time.LocalDate;

public class AtorRequest {

    private String nome;
    private LocalDate dataNascimento;
    private StatusCarreira statusCarreira;
    private int anoInicioAtividade;
    private Ator ator;

    public AtorRequest(String nome, LocalDate dataNascimento, StatusCarreira statusCarreira, int anoInicioAtividade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.statusCarreira = statusCarreira;
        this.anoInicioAtividade = anoInicioAtividade;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public StatusCarreira getStatusCarreira() {
        return statusCarreira;
    }

    public int getAnoInicioAtividade() {
        return anoInicioAtividade;
    }
}
