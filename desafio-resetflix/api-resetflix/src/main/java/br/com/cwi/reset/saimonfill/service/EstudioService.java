package br.com.cwi.reset.saimonfill.service;

import br.com.cwi.reset.saimonfill.FakeDatabase;
import br.com.cwi.reset.saimonfill.exception.*;
import br.com.cwi.reset.saimonfill.model.Ator;
import br.com.cwi.reset.saimonfill.model.Diretor;
import br.com.cwi.reset.saimonfill.model.Estudio;
import br.com.cwi.reset.saimonfill.request.AtorRequest;
import br.com.cwi.reset.saimonfill.request.EstudioRequest;
import br.com.cwi.reset.saimonfill.validator.EstudioRequestCamposObrigatoriosValidator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class EstudioService {

    private FakeDatabase fakeDatabase;
    private Estudio estudio;

    public EstudioService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void criarEstudio(EstudioRequest estudioRequest) throws Exception {

        new EstudioRequestCamposObrigatoriosValidator().accept(estudioRequest);

        verificaMesmoNome(estudioRequest);
        verificaDataCriacao(estudioRequest);

        List<Estudio> estudioSize = fakeDatabase.recuperaEstudios();
        Integer id = estudioSize.size() + 1;

        estudio = new Estudio(
                estudioRequest.getNome(),
                estudioRequest.getDescricao(),
                estudioRequest.getDataCriacao(),
                estudioRequest.getStatusAtividade()
        );

        fakeDatabase.persisteEstudio(estudio);
    }

    public void verificaMesmoNome(EstudioRequest estudioRequest) throws Exception {

        List<Estudio> listaNomes = fakeDatabase.recuperaEstudios();
        String nomeRequerido = estudioRequest.getNome();

        for (int i = 0; i < listaNomes.size(); i++) {
            if (listaNomes.get(i).getNome().contains(nomeRequerido)) {
                throw new JaExisteCadastradoException("estudio", nomeRequerido);
            }
        }
    }

    public void verificaDataCriacao(EstudioRequest estudioRequest) throws Exception {

        LocalDate dataAtual = LocalDate.now();
        LocalDate dataCriacao = estudioRequest.getDataCriacao();
        boolean comparaDatas = dataCriacao.isAfter(dataAtual);

        if (comparaDatas) {
            throw new NaoCadastrarEstudioFuturoException(TipoDominioException.ESTUDIO.name());
        }
    }

    public List<Estudio> consultarEstudios(String filtroNome) throws Exception {

        List<Estudio> estudios = fakeDatabase.recuperaEstudios();
        List<Estudio> estudioEncontrado = new ArrayList<>();

        if (estudios.isEmpty()) {
            throw new ListaVaziaException("diretor", "diretores");
        }

        if (filtroNome != null) {
            for (int i = 0; i < estudios.size(); i++) {

                boolean containsFiltro = estudios.get(i).getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT));

                if (containsFiltro == true) {
                    estudioEncontrado.add(estudios.get(i));
                }
            }
        }
        else {
            estudioEncontrado.addAll(estudios);
        }

        return estudioEncontrado;
    }

    public Estudio consultarEstudio(Integer id) throws Exception {

        List<Estudio> estudios = fakeDatabase.recuperaEstudios();

        if (id == null) {
            throw new CampoNaoInformadoException("id");
        }
        else if (!estudios.isEmpty()) {
            for (Estudio estudio : estudios) {
                if (estudio.getId() == id) {
                    return estudio;
                }
            }
        } else {
            throw new ConsultarPeloIdException("estudio", id);
        }
        return null;
    }
}
