package br.com.cwi.reset.saimonfill;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class AtorEmAtividade {

    private FakeDatabase fakeDatabase = new FakeDatabase();
    private Ator ator;
    private AtorEmAtividade atorEmAtividade;

    private Integer id;
    private String nome;
    private LocalDate dataNascimento;

//    public AtorEmAtividade(Integer id, String nome, LocalDate dataNascimento) {
//        this.id = id;
//        this.nome = nome;
//        this.dataNascimento = dataNascimento;
//    }

    public void listarAtoresEmAtividade() {
        List<Ator> atores = fakeDatabase.recuperaAtores();

        StatusCarreira filtro = StatusCarreira.EM_ATIVIDADE;

        List<Ator> listaAtorEmAtividade = atores.stream()
                .filter(x -> x.getStatusCarreira() == filtro)
                .collect(Collectors.toList());

//            List<AtorEmAtividade> listaAtorEmAtividade = new ArrayList<>();

//            for (int i = 0; i < atores.size(); i++) {
//                if (atores.get(i).getStatusCarreira() == filtro) {
//                    atorEmAtividade = new AtorEmAtividade(
//                            atores.get(i).getId(),
//                            atores.get(i).getNome(),
//                            atores.get(i).getDataNascimento()
//                    );
//                    listaAtorEmAtividade.add(atorEmAtividade);
//                }
//            }
        System.out.println(listaAtorEmAtividade);
    }

    @Override
    public String toString() {
        return "AtorEmAtividade{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
