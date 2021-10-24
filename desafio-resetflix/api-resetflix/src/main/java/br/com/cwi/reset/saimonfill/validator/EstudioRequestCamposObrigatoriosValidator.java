package br.com.cwi.reset.saimonfill.validator;

import br.com.cwi.reset.saimonfill.exception.DataCriacaoNaoInformadoException;
import br.com.cwi.reset.saimonfill.exception.DescricaoNaoInformadaException;
import br.com.cwi.reset.saimonfill.exception.NomeNaoInformadoException;
import br.com.cwi.reset.saimonfill.exception.StatusAtividadeNaoInformadoException;
import br.com.cwi.reset.saimonfill.request.EstudioRequest;

import static java.util.Objects.isNull;

public class EstudioRequestCamposObrigatoriosValidator {

    public void accept(EstudioRequest estudioRequest) throws Exception {
        if (isNull(estudioRequest.getNome())) {
            throw new NomeNaoInformadoException();
        }

        if (isNull(estudioRequest.getDataCriacao())) {
            throw new DataCriacaoNaoInformadoException();
        }

        if (isNull(estudioRequest.getDescricao())) {
            throw new DescricaoNaoInformadaException();
        }

        if (isNull(estudioRequest.getStatusAtividade())) {
            throw new StatusAtividadeNaoInformadoException();
        }
    }
}
