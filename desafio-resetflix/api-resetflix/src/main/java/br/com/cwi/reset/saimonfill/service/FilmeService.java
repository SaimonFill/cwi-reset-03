package br.com.cwi.reset.saimonfill.service;

import br.com.cwi.reset.saimonfill.FakeDatabase;
import br.com.cwi.reset.saimonfill.exception.*;
import br.com.cwi.reset.saimonfill.model.*;
import br.com.cwi.reset.saimonfill.request.FilmeRequest;
import br.com.cwi.reset.saimonfill.request.PersonagemRequest;

import java.util.*;

import static java.util.Objects.isNull;

public class FilmeService {

    private FakeDatabase fakeDatabase;
    private DiretorService diretorService;
    private EstudioService estudioService;
    private PersonagemService personagemService;
    private PersonagemRequest personagemRequest;

    public FilmeService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
        this.diretorService = new DiretorService(fakeDatabase);
        this.estudioService = new EstudioService(fakeDatabase);
        this.personagemService = new PersonagemService(fakeDatabase);
    }

    public void criarFilme(FilmeRequest filmeRequest) throws Exception {

        Diretor idDiretor = diretorService.consultarDiretor(filmeRequest.getIdDiretor());
        Estudio idEstudio = estudioService.consultarEstudio(filmeRequest.getIdEstudio());
        List<PersonagemAtor> personagens = personagemService.cadastrarPersonagensFilme(filmeRequest.getPersonagens());

        List<Filme> idFilme = fakeDatabase.recuperaFilmes();
        Integer id = idFilme.size() + 1;

        Filme filme = new Filme(
                id,
                filmeRequest.getNome(),
                filmeRequest.getAnoLancamento(),
                filmeRequest.getCapaFilme(),
                filmeRequest.getGeneros(),
                idDiretor,
                idEstudio,
                personagens,
                filmeRequest.getResumo()
        );

        verificaGenero(filmeRequest);

        fakeDatabase.persisteFilme(filme);
    }

    public void verificaGenero(FilmeRequest filmeRequest) throws GeneroNaoInformadoException, GeneroIgualException {
        List<Filme> filmes = fakeDatabase.recuperaFilmes();

        for (Filme filme : filmes) {
            if(filme.getGeneros().isEmpty()) {
                throw new GeneroNaoInformadoException();
            }
        }

        final Set<Genero> generoSet = new HashSet<>();

        Filme filme = null;

        for (Genero genero : filme.getGeneros()) {
            if (generoSet.contains(genero)) {
                throw new GeneroIgualException();
            } else {
                generoSet.add(genero);
            }
        }
    }

    public List<Filme> consultarFilmes(
            String nomeFilme,
            String nomeDiretor,
            String nomePersonagem,
            String nomeAtor) throws Exception {
        final List<Filme> filmesCadastrados = fakeDatabase.recuperaFilmes();

        if (filmesCadastrados.isEmpty()) {
            throw new ListaVaziaException(TipoDominioException.FILME.getSingular(), TipoDominioException.FILME.getPlural());
        }

        final List<Filme> filtrarNomePersonagem = filtrarNomePersonagem(filmesCadastrados, nomePersonagem);
        final List<Filme> filtrarNomeAtor = filtrarNomeAtor(filtrarNomePersonagem, nomeAtor);
        final List<Filme> filtrarNomeDiretor = filtrarNomeDiretor(filtrarNomeAtor, nomeDiretor);
        final List<Filme> filtroFinal = filtrarNomeFilme(filtrarNomeDiretor, nomeFilme);

        if (filtroFinal.isEmpty()) {
            throw new FiltrosFilmeNaoEncontradosException(nomeFilme, nomeDiretor, nomePersonagem, nomeAtor);
        }

        return filtroFinal;
    }

    private List<Filme> filtrarNomeFilme(final List<Filme> listaOriginal, final String nome) {
        if (isNull(nome)) {
            return listaOriginal;
        }

        final List<Filme> filmeFiltrado = new ArrayList<>();

        for (Filme filme : listaOriginal) {
            if (filme.getNome().toLowerCase(Locale.ROOT).equalsIgnoreCase(nome.toLowerCase(Locale.ROOT))) {
                filmeFiltrado.add(filme);
            }
        }

        return filmeFiltrado;
    }

    private List<Filme> filtrarNomeDiretor(final List<Filme> listaOriginal, final String nome) {
        if (isNull(nome)) {
            return listaOriginal;
        }

        final List<Filme> filmeFiltrado = new ArrayList<>();

        for (Filme filme : listaOriginal) {
            if (filme.getDiretor().getNome().toLowerCase(Locale.ROOT).equalsIgnoreCase(nome.toLowerCase(Locale.ROOT))) {
                filmeFiltrado.add(filme);
            }
        }

        return filmeFiltrado;
    }

    private List<Filme> filtrarNomeAtor(final List<Filme> listaOriginal, final String nome) {
        if (isNull(nome)) {
            return listaOriginal;
        }

        final List<Filme> filmeFiltrado = new ArrayList<>();

        for (Filme filme : listaOriginal) {
            for (PersonagemAtor personagens : filme.getPersonagens()) {
                if (personagens.getAtor().getNome().toLowerCase(Locale.ROOT).equalsIgnoreCase(nome.toLowerCase(Locale.ROOT))) {
                    filmeFiltrado.add(filme);
                    break;
                }
            }
        }

        return filmeFiltrado;
    }

    private List<Filme> filtrarNomePersonagem(final List<Filme> listaOriginal, final String nome) {
        if (isNull(nome)) {
            return listaOriginal;
        }

        final List<Filme> filmeFiltrado = new ArrayList<>();

        for (Filme filme : listaOriginal) {
            for (PersonagemAtor personagens : filme.getPersonagens()) {
                if (personagens.getNomePersonagem()
                        .toLowerCase(Locale.ROOT)
                        .equalsIgnoreCase(nome.toLowerCase(Locale.ROOT))
                ) {
                    filmeFiltrado.add(filme);
                    break;
                }
            }
        }

        return filmeFiltrado;
    }

}
