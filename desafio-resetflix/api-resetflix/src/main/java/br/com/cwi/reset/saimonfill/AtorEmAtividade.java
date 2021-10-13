package br.com.cwi.reset.saimonfill;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class AtorEmAtividade {

    private FakeDatabase fakeDatabase;
    private Ator ator;

    private Integer id;
    private String nome;
    private LocalDate dataNascimento;

    public AtorEmAtividade(Integer id, String nome, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

//    public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome) {
//
//        StatusCarreira filtro = StatusCarreira.EM_ATIVIDADE;
//        List<Ator> resultado = fakeDatabase.recuperaAtores();
//
//        List<Ator> listaAtorEmAtividade = resultado.stream()
//                .filter(x -> x.getStatusCarreira() == filtro)
//                .collect(Collectors.toList());
//
//        List<AtorEmAtividade> teste = listaAtorEmAtividade;
//
//        return listaAtorEmAtividade;
//    }

    @Override
    public String toString() {
        return "AtorEmAtividade{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
