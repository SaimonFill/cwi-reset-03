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

    public Ator consultarAtor(Integer id) throws AtorException {

        if (id == null) {
            throw new AtorException("Campo obrigatório não informado. Favor informar o campo ID.");
        }

        return atores.stream().filter(x -> x.getId().equals(id)).findAny().
                orElseThrow(() -> new AtorException
                        ("Nenhum ator encontrado com o parâmetro id=" + id + ", favor verifique os parâmetros informados."));
    }

    public List<Ator> consultarAtores() throws AtorException {

        if (atores.isEmpty()) {
            throw new AtorException("Nenhum ator cadastrado, favor cadastar atores.");
        }

        return atores;
    }

    public void persisteDiretor(Diretor diretor) {
        diretores.add(diretor);
    }

    public List<Diretor> recuperaDiretores() {
        return diretores;
    }

    public List<Diretor> listarDiretores(String filtroNome) throws AtorException {

        if (diretores.isEmpty()) {
            throw new AtorException("Nenhum diretor cadastrado, favor cadastar atores.");
        }

        return diretores;
    }

    public Diretor consultarDiretor(Integer id) throws AtorException {

        if (id == null) {
            throw new AtorException("Campo obrigatório não informado. Favor informar o campo ID.");
        }

        return diretores.stream().filter(x -> x.getId().equals(id)).findAny().
                orElseThrow(() -> new AtorException
                        ("Nenhum diretor encontrado com o parâmetro id=" + id + ", favor verifique os parâmetros informados."));
    }
}