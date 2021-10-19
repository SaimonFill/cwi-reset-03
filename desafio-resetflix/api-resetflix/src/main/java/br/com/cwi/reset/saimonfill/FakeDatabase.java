package br.com.cwi.reset.saimonfill;

import br.com.cwi.reset.saimonfill.exception.CampoNaoInformadoException;
import br.com.cwi.reset.saimonfill.exception.ConsultarPeloIdException;
import br.com.cwi.reset.saimonfill.exception.ListaVaziaException;
import br.com.cwi.reset.saimonfill.model.*;
import br.com.cwi.reset.saimonfill.response.AtorEmAtividade;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FakeDatabase {

    private static FakeDatabase fakeDatabase = new FakeDatabase();

    public static FakeDatabase getInstance() {
        return fakeDatabase;
    }

    private FakeDatabase() {
    }

    private List<Ator> atores = new ArrayList<>();
    private List<Diretor> diretores = new ArrayList<>();
    private List<Estudio> estudios = new ArrayList<>();
    private List<Filme> filmes = new ArrayList<>();
    private List<PersonagemAtor> personagens = new ArrayList<>();

    public void persisteAtor(Ator ator) {
        atores.add(ator);
    }

    public List<Ator> recuperaAtores() {
        return atores;
    }

    public void persisteDiretor(Diretor diretor) {
        diretores.add(diretor);
    }

    public List<Diretor> recuperaDiretores() {
        return diretores;
    }

    public void persisteEstudio(Estudio estudio) {
        estudios.add(estudio);
    }

    public List<Estudio> recuperaEstudios() {
        return estudios;
    }

    public void persisteFilme(Filme filme) {
        filmes.add(filme);
    }

    public List<Filme> recuperaFilmes() {
        return filmes;
    }

    public void persistePersonagem(PersonagemAtor personagemAtor) {
        personagens.add(personagemAtor);
    }

    public List<PersonagemAtor> recuperaPersonagens() {
        return personagens;
    }

    public List<Ator> consultarAtores() throws Exception {

        if (atores.isEmpty()) {
            throw new ListaVaziaException("ator", "atores");
        }

        return atores;
    }

    public List<Diretor> listarDiretores(String filtroNome) throws Exception {

        if (diretores.isEmpty()) {
            throw new ListaVaziaException("diretor", "diretores");
        }

        return diretores;
    }

    public Diretor consultarDiretor(Integer id) throws Exception {

        if (id == null) {
            throw new CampoNaoInformadoException("id");
        }

        return diretores.stream().filter(x -> x.getId().equals(id)).findAny().
                orElseThrow(() -> new ConsultarPeloIdException("diretor", id));
    }
}