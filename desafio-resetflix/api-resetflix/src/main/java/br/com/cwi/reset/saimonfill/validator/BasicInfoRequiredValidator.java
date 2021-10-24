package br.com.cwi.reset.saimonfill.validator;

import br.com.cwi.reset.saimonfill.exception.*;

import java.time.LocalDate;

public class BasicInfoRequiredValidator {

    public void accept(final String nome, final LocalDate dataNascimento, final Integer anoInicioAtividade, final TipoDominioException tipoDominioException) throws Exception {
        if (anoInicioAtividade == null) {
            throw new AnoInicioAtividadeNaoInformadoException();
        }

        if (nome.split(" ").length < 2) {
            throw new InformarNomeSobrenomeException(tipoDominioException.getSingular());
        }

        if (LocalDate.now().isBefore(dataNascimento)) {
            throw new NaoCadastrarEstudioFuturoException(tipoDominioException.getPlural());
        }

        if (anoInicioAtividade <= dataNascimento.getYear()) {
            throw new AnoInicioInvalidoException(tipoDominioException.getSingular());
        }
    }
}