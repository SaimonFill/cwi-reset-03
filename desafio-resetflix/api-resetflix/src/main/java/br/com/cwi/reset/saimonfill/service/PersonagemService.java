package br.com.cwi.reset.saimonfill.service;

import br.com.cwi.reset.saimonfill.FakeDatabase;
import br.com.cwi.reset.saimonfill.model.Ator;
import br.com.cwi.reset.saimonfill.model.PersonagemAtor;
import br.com.cwi.reset.saimonfill.request.PersonagemRequest;

import java.util.ArrayList;
import java.util.List;

public class PersonagemService {

    private FakeDatabase fakeDatabase;
    private AtorService atorService;

    public PersonagemService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
        this.atorService = new AtorService((FakeDatabase.getInstance()));
    }

    public List<PersonagemAtor> criarPersonagem(List<PersonagemRequest> personagens) throws Exception {

        List<PersonagemAtor> personagensAtores = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();

        for (PersonagemRequest personagemRequests : personagens) {

            List<PersonagemAtor> idPersonagem = fakeDatabase.recuperaPersonagens();
            Integer id = idPersonagem.size() + 1;

            Integer idAtor = personagemRequests.getIdAtor();
            Ator ator = atorService.consultarAtor(idAtor);

            PersonagemAtor personagemAtor = new PersonagemAtor(
                    id,
                    ator,
                    personagemRequests.getNomePersonagem(),
                    personagemRequests.getDescricaoPersonagem(),
                    personagemRequests.getTipoAtuacao());

            personagensAtores.add(personagemAtor);
            fakeDatabase.persistePersonagem(personagemAtor);
        }

        return personagensAtores;

    }
}
