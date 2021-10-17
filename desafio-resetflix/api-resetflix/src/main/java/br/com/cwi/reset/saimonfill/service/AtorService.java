package br.com.cwi.reset.saimonfill.service;

import br.com.cwi.reset.saimonfill.FakeDatabase;
import br.com.cwi.reset.saimonfill.exception.AtorException;
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
    public void criarAtor(AtorRequest atorRequest) throws AtorException {

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

    public void verificaCamposObrigatorios(AtorRequest atorRequest) throws AtorException {

        if (atorRequest.getNome().isEmpty()) {
            throw new AtorException("Campo obrigatório não informado. Favor informar o campo 'Nome'.");
        }
        if (atorRequest.getDataNascimento() == null) {
            throw new AtorException("Campo obrigatório não informado. Favor informar o campo 'dataNascimento'.");
        }
        if (atorRequest.getStatusCarreira() == null) {
            throw new AtorException("Campo obrigatório não informado. Favor informar o campo 'statusCarreira'.");
        }
        if (atorRequest.getAnoInicioAtividade() == null) {
            throw new AtorException("Campo obrigatório não informado. Favor informar o campo 'anoInicioAtividade'.");
        }
    }

    public void verificaNomeSobrenome(AtorRequest atorRequest) throws AtorException {

        String nome = atorRequest.getNome();
        String[] arrayNome = nome.split(" ");

        if (arrayNome.length <= 1) {
            throw new AtorException("Deve ser informado no mínimo nome e sobrenome para o ator.");
        }
    }

    public void verificaDataNascimento(AtorRequest atorRequest) throws AtorException {

        LocalDate dataAtual = LocalDate.now();
        LocalDate dataNascimento = atorRequest.getDataNascimento();
        boolean comparaDatas = dataNascimento.isAfter(dataAtual);

        if (comparaDatas) {
            throw new AtorException("Não é possível cadastrar atores não nascidos.");
        }
    }

    public void verificaMesmoNome(AtorRequest atorRequest) throws AtorException {

        List<Ator> listaNomes = fakeDatabase.recuperaAtores();
        String nomeRequerido = atorRequest.getNome();

        for (int i = 0; i < listaNomes.size(); i++) {
            if (listaNomes.get(i).getNome().contains(nomeRequerido)) {
                throw new AtorException("Já existe um ator cadastrado para o nome " + atorRequest.getNome());
            }
        }
    }

    public void verificaAnoInicioAtividade(AtorRequest atorRequest) throws AtorException {

        LocalDate dataNascimento = atorRequest.getDataNascimento();
        LocalDate inicioAtividade = LocalDate.ofYearDay(atorRequest.getAnoInicioAtividade(), 1);

        boolean comparaDatas = dataNascimento.isAfter(inicioAtividade);

        if (comparaDatas) {
            throw new AtorException("Ano de início de atividade inválido para o ator cadastrado.");
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

    public List<AtorEmAtividade> listarAtoresEmAtividade(Optional<String> filtroNome) throws AtorException {

        List<Ator> atores = fakeDatabase.recuperaAtores();
        StatusCarreira filtroCarreira = StatusCarreira.EM_ATIVIDADE;
        List<AtorEmAtividade> atorEmAtividade = fakeDatabase.filtraAtoresEmAtividade(filtroNome);

        if (atores.isEmpty()) {
            throw new AtorException("Nenhum ator cadastrado, favor cadastar atores.");
        }
        if (atorEmAtividade.contains(filtroCarreira)) {
            throw new AtorException("Ator não encontrato com o filtro " + filtroCarreira + ", favor informar outro filtro.");
        }

        return atorEmAtividade;
    }

    // Demais métodos da classe
}