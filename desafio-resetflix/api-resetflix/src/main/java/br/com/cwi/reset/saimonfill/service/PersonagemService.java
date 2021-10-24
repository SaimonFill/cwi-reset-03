package br.com.cwi.reset.saimonfill.service;

import br.com.cwi.reset.saimonfill.FakeDatabase;
import br.com.cwi.reset.saimonfill.exception.AtorPersonagemIguaisException;
import br.com.cwi.reset.saimonfill.exception.ValidacaoForaDaRegraException;
import br.com.cwi.reset.saimonfill.model.Ator;
import br.com.cwi.reset.saimonfill.model.PersonagemAtor;
import br.com.cwi.reset.saimonfill.request.PersonagemRequest;
import br.com.cwi.reset.saimonfill.validator.PersonagemRequestCamposObrigatoriosValidator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonagemService {

    private FakeDatabase fakeDatabase;
    private AtorService atorService;

    public PersonagemService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
        this.atorService = new AtorService((FakeDatabase.getInstance()));
    }

    public PersonagemAtor cadastrarPersonagemAtor(PersonagemRequest personagemRequest) throws Exception {
        new PersonagemRequestCamposObrigatoriosValidator().accept(personagemRequest);

        final Integer idGerado = fakeDatabase.recuperaPersonagens().size() + 1;
        final Ator ator = atorService.consultarAtor(personagemRequest.getIdAtor());

        final PersonagemAtor personagemAtor = new PersonagemAtor(
                ator,
                personagemRequest.getNomePersonagem(),
                personagemRequest.getDescricaoPersonagem(),
                personagemRequest.getTipoAtuacao());

        fakeDatabase.persistePersonagem(personagemAtor);

        return personagemAtor;
    }

    public List<PersonagemAtor> consultarPersonagemAtor(String nome) throws Exception {
        return fakeDatabase.recuperaPersonagens();
    }

    private void validarPersonagensAtoresFilme(final List<PersonagemRequest> personagens) throws Exception {
        if (personagens.isEmpty()) {
            throw new ValidacaoForaDaRegraException();
        }

        final Set<PersonagemRequest> personagemRequestSet = new HashSet<>();

        for (PersonagemRequest personagemRequest : personagens) {
            new PersonagemRequestCamposObrigatoriosValidator().accept(personagemRequest);

            if (personagemRequestSet.contains(personagemRequest)) {
                throw new AtorPersonagemIguaisException();
            } else {
                personagemRequestSet.add(personagemRequest);
            }
        }
    }

    public List<PersonagemAtor> cadastrarPersonagensFilme(final List<PersonagemRequest> personagens) throws Exception {
        validarPersonagensAtoresFilme(personagens);

        final List<PersonagemAtor> personagensAtores = new ArrayList<>();

        for (PersonagemRequest request : personagens) {
            personagensAtores.add(cadastrarPersonagemAtor(request));
        }

        return personagensAtores;
    }

}
