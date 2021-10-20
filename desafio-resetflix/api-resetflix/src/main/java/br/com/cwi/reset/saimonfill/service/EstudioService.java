package br.com.cwi.reset.saimonfill.service;

import br.com.cwi.reset.saimonfill.FakeDatabase;
import br.com.cwi.reset.saimonfill.exception.*;
import br.com.cwi.reset.saimonfill.model.Ator;
import br.com.cwi.reset.saimonfill.model.Diretor;
import br.com.cwi.reset.saimonfill.model.Estudio;
import br.com.cwi.reset.saimonfill.request.AtorRequest;
import br.com.cwi.reset.saimonfill.request.EstudioRequest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class EstudioService {

    private FakeDatabase fakeDatabase;
    private Estudio estudio;

    public EstudioService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void criarEstudio(EstudioRequest estudioRequest) throws Exception {

        verificaCamposObrigatorios(estudioRequest);
        verificaMesmoNome(estudioRequest);
        verificaDataCriacao(estudioRequest);

        List<Estudio> estudioSize = fakeDatabase.recuperaEstudios();
        Integer id = estudioSize.size() + 1;

        estudio = new Estudio(
                id,
                estudioRequest.getNome(),
                estudioRequest.getDescricao(),
                estudioRequest.getDataCriacao(),
                estudioRequest.getStatusAtividade()
        );

        fakeDatabase.persisteEstudio(estudio);
    }

    public void verificaCamposObrigatorios(EstudioRequest estudioRequest) throws Exception {

        if (estudioRequest.getNome().isEmpty()) {
            throw new NomeNaoInformadoException();
        }
        if (estudioRequest.getDescricao().isEmpty()) {
            throw new DescricaoNaoInformadoException();
        }
        if (estudioRequest.getDataCriacao() == null) {
            throw new DataCriacaoNaoInformadoException();
        }
        if (estudioRequest.getStatusAtividade() == null) {
            throw new StatusAtividadeNaoInformadoException();
        }
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
            throw new NaoCadastrarEstudioFuturoException();
        }
    }

    public List<Estudio> consultarEstudios(Optional<String> filtroNome) throws Exception {

        List<Estudio> estudios = fakeDatabase.recuperaEstudios();

        if (estudios.isEmpty()) {
            throw new ListaVaziaException("estudio", "estudios");
        }

        return estudios;
    }

    public Estudio consultarEstudio(Integer id) throws Exception {

        List<Estudio> estudios = fakeDatabase.recuperaEstudios();

        if (id == null) {
            throw new CampoNaoInformadoException("id");
        }

        return estudios.stream().filter(x -> x.getId().equals(id)).findAny().
                orElseThrow(() -> new ConsultarPeloIdException("estudio", id));
    }
}
