package br.com.cwi.reset.saimonfill;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FakeDatabase {

    private List<Ator> atores = new ArrayList<>();
    private List<Diretor> diretores = new ArrayList<>();

    public void persisteAtor(Ator ator) {
        atores.add(ator);
    }

    public List<Ator> recuperaAtores() {
        return atores;
    }

    public List<AtorEmAtividade> filtraAtoresEmAtividade(String filtroNome) {
        StatusCarreira filtroCarreira = StatusCarreira.EM_ATIVIDADE;

        return atores.stream().filter(x -> x.getStatusCarreira().equals(filtroCarreira))
                .map(a -> new AtorEmAtividade(a.getId(), a.getNome(), a.getDataNascimento()))
                .collect(Collectors.toList());
    }

    public void persisteDiretor(Diretor diretor) {
        diretores.add(diretor);
    }

    public List<Diretor> recuperaDiretores() {
        return diretores;
    }
}