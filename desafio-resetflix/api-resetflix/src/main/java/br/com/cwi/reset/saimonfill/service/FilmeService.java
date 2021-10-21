package br.com.cwi.reset.saimonfill.service;

import br.com.cwi.reset.saimonfill.FakeDatabase;
import br.com.cwi.reset.saimonfill.model.Diretor;
import br.com.cwi.reset.saimonfill.model.Estudio;
import br.com.cwi.reset.saimonfill.model.Filme;
import br.com.cwi.reset.saimonfill.model.PersonagemAtor;
import br.com.cwi.reset.saimonfill.request.FilmeRequest;

import java.util.List;

public class FilmeService {

    private FakeDatabase fakeDatabase;
    private DiretorService diretorService;
    private EstudioService estudioService;
    private PersonagemService personagemService;

    public FilmeService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
        this.diretorService = new DiretorService(FakeDatabase.getInstance());
        this.estudioService = new EstudioService((FakeDatabase.getInstance()));
        this.personagemService = new PersonagemService((FakeDatabase.getInstance()));
    }

    public void criarFilme(FilmeRequest filmeRequest) throws Exception {

        Diretor idDiretor = diretorService.consultarDiretor(filmeRequest.getIdDiretor());
        Estudio idEstudio = estudioService.consultarEstudio(filmeRequest.getIdEstudio());
        List<PersonagemAtor> personagens = personagemService.criarPersonagem(filmeRequest.getPersonagens());

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
                personagens
        );

        fakeDatabase.persisteFilme(filme);
    }

}
