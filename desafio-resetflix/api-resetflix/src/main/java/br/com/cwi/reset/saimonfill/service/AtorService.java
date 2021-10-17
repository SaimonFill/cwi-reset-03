package br.com.cwi.reset.saimonfill.service;

import br.com.cwi.reset.saimonfill.FakeDatabase;
import br.com.cwi.reset.saimonfill.exception.*;
import br.com.cwi.reset.saimonfill.model.Ator;
import br.com.cwi.reset.saimonfill.model.StatusCarreira;
import br.com.cwi.reset.saimonfill.request.AtorRequest;
import br.com.cwi.reset.saimonfill.response.AtorEmAtividade;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class AtorService {

    private FakeDatabase fakeDatabase;
    private Ator ator;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    //Confirmar se este método está correto
    public void criarAtor(AtorRequest atorRequest) throws Exception {

        verificaCamposObrigatorios(atorRequest);
        verificaNomeSobrenome(atorRequest);
        verificaMesmoNome(atorRequest);
        verificaDataNascimento(atorRequest);
        verificaAnoInicioAtividade(atorRequest);

        ator = new Ator(
                atorRequest.getNome(),
                atorRequest.getDataNascimento(),
                atorRequest.getStatusCarreira(),
                atorRequest.getAnoInicioAtividade()
        );

        setId();
        fakeDatabase.persisteAtor(ator);
    }

    public void verificaCamposObrigatorios(AtorRequest atorRequest) throws Exception {

        if (atorRequest.getNome().isEmpty()) {
            throw new NomeNaoInformadoException();
        }
        if (atorRequest.getDataNascimento() == null) {
            throw new DataNascimentoNaoInformadoException();
        }
        if (atorRequest.getStatusCarreira() == null) {
            throw new StatusCarreiraNaoInformadoException();
        }
        if (atorRequest.getAnoInicioAtividade() == null) {
            throw new AnoInicioAtividadeNaoInformadoException();
        }
    }

    public void verificaNomeSobrenome(AtorRequest atorRequest) throws Exception {

        String nome = atorRequest.getNome();
        String[] arrayNome = nome.split(" ");

        if (arrayNome.length <= 1) {
            throw new InformarNomeSobrenomeException("ator");
        }
    }

    public void verificaDataNascimento(AtorRequest atorRequest) throws Exception {

        LocalDate dataAtual = LocalDate.now();
        LocalDate dataNascimento = atorRequest.getDataNascimento();
        boolean comparaDatas = dataNascimento.isAfter(dataAtual);

        if (comparaDatas) {
            throw new NaoCadastrarNaoNacidosException("atores");
        }
    }

    public void verificaMesmoNome(AtorRequest atorRequest) throws Exception {

        List<Ator> listaNomes = fakeDatabase.recuperaAtores();
        String nomeRequerido = atorRequest.getNome();

        for (int i = 0; i < listaNomes.size(); i++) {
            if (listaNomes.get(i).getNome().contains(nomeRequerido)) {
                throw new JaExisteCadastradoException("ator", nomeRequerido);
            }
        }
    }

    public void verificaAnoInicioAtividade(AtorRequest atorRequest) throws Exception {

        LocalDate dataNascimento = atorRequest.getDataNascimento();
        LocalDate inicioAtividade = LocalDate.ofYearDay(atorRequest.getAnoInicioAtividade(), 1);

        boolean comparaDatas = dataNascimento.isAfter(inicioAtividade);

        if (comparaDatas) {
            throw new AnoInicioInvalidoException("ator");
        }
    }

    public void setId() {
        List<Ator> listaId = fakeDatabase.recuperaAtores();

        Integer id = 1;
        ator.setId(id);

        for (int i = 0; i < listaId.size(); i++) {
            if (ator.getId() == listaId.get(i).getId()) {
                ator.setId(id);
            }
        }
    }

    public List<AtorEmAtividade> listarAtoresEmAtividade(Optional<String> filtroNome) throws Exception {

        List<Ator> atores = fakeDatabase.recuperaAtores();
        StatusCarreira filtroCarreira = StatusCarreira.EM_ATIVIDADE;
        List<AtorEmAtividade> atorEmAtividade = fakeDatabase.filtraAtoresEmAtividade(filtroNome);

        if (atores.isEmpty()) {
            throw new ListaVaziaException("ator", "atores");
        }
        if (atorEmAtividade.contains(filtroCarreira)) {
            throw new FiltroNomeNaoEncontrado("ator", filtroNome);
        }

        return atorEmAtividade;
    }

    // Demais métodos da classe
}