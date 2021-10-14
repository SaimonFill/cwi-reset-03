package br.com.cwi.reset.saimonfill;

import java.time.LocalDate;
import java.util.List;

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

        ator = new Ator(
                atorRequest.getNome(),
                atorRequest.getDataNascimento(),
                atorRequest.getStatusCarreira(),
                atorRequest.getAnoInicioAtividade()
        );

        setId();
        fakeDatabase.persisteAtor(ator);
    }

    //terminar de implementar a regra do método
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

    public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome) throws AtorException {
        List<Ator> atores = fakeDatabase.recuperaAtores();
        StatusCarreira filtroCarreira = StatusCarreira.EM_ATIVIDADE;
        List<AtorEmAtividade> atorEmAtividade = fakeDatabase.filtraAtoresEmAtividade("");

        if (atores.isEmpty()) {
            throw new AtorException("Nenhum ator cadastrado, favor cadastar atores.");
        }
        if (atorEmAtividade.isEmpty()) {
            throw new AtorException("Ator não encontrato com o filtro " + filtroCarreira + ", favor informar outro filtro.");
        }

        return fakeDatabase.filtraAtoresEmAtividade(filtroNome);
    }

    public Ator consultarAtor(Integer id) throws AtorException {
        List<Ator> atores = fakeDatabase.recuperaAtores();

        if (id == null) {
            throw new AtorException("Campo obrigatório não informado. Favor informar o campo ID.");
        }

        return atores.stream().filter(x -> x.getId().equals(id)).findAny().
                orElseThrow(() -> new AtorException
                        ("Nenhum ator encontrado com o parâmetro id=" + id + ", favor verifique os parâmetros informados."));
    }

    public List<Ator> consultarAtores() throws AtorException {
        List<Ator> atores = fakeDatabase.recuperaAtores();

        if (atores.isEmpty()) {
            throw new AtorException("Nenhum ator cadastrado, favor cadastar atores.");
        }

        return atores;
    }

    // Demais métodos da classe
}