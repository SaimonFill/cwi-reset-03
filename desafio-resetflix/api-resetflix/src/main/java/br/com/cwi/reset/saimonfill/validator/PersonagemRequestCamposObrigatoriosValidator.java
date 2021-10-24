package br.com.cwi.reset.saimonfill.validator;

import br.com.cwi.reset.saimonfill.exception.DescricaoPersonagemNaoInformadaException;
import br.com.cwi.reset.saimonfill.exception.IdAtorNaoInformadoException;
import br.com.cwi.reset.saimonfill.exception.NomeNaoInformadoException;
import br.com.cwi.reset.saimonfill.exception.TipoAtuacaoNaoInformadoException;
import br.com.cwi.reset.saimonfill.request.PersonagemRequest;

import static java.util.Objects.isNull;

public class PersonagemRequestCamposObrigatoriosValidator {

    public void accept(final PersonagemRequest personagemRequest) throws Exception {
        if (isNull(personagemRequest.getNomePersonagem())) {
            throw new NomeNaoInformadoException();
        }

        if (isNull(personagemRequest.getDescricaoPersonagem())) {
            throw new DescricaoPersonagemNaoInformadaException();
        }

        if (isNull(personagemRequest.getIdAtor())) {
            throw new IdAtorNaoInformadoException();
        }

        if (isNull(personagemRequest.getTipoAtuacao())) {
            throw new TipoAtuacaoNaoInformadoException();
        }
    }
}
