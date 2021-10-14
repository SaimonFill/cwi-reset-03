package br.com.cwi.reset.saimonfill;

import java.time.LocalDate;
import java.util.List;

public class DiretorService {

    private FakeDatabase fakeDatabase;
    private Diretor diretor;

    public DiretorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void cadastrarDiretor(DiretorRequest diretorRequest) throws AtorException {

        verificaCamposObrigatorios(diretorRequest);
        verificaNomeSobrenome(diretorRequest);
        verificaMesmoNome(diretorRequest);
        verificaDataNascimento(diretorRequest);

        diretor = new Diretor(
                diretorRequest.getNome(),
                diretorRequest.getDataNascimento(),
                diretorRequest.getAnoInicioAtividade()
        );

        setId();
        fakeDatabase.persisteDiretor(diretor);
    }

    public void verificaCamposObrigatorios(DiretorRequest diretorRequest) throws AtorException {

        if (diretorRequest.getNome().isEmpty()) {
            throw new AtorException("Campo obrigatório não informado. Favor informar o campo 'Nome'.");
        }
        if (diretorRequest.getDataNascimento() == null) {
            throw new AtorException("Campo obrigatório não informado. Favor informar o campo 'dataNascimento'.");
        }
        if (diretorRequest.getAnoInicioAtividade() == null) {
            throw new AtorException("Campo obrigatório não informado. Favor informar o campo 'anoInicioAtividade'.");
        }
    }

    public void verificaNomeSobrenome(DiretorRequest diretorRequest) throws AtorException {

        String nome = diretorRequest.getNome();
        String[] arrayNome = nome.split(" ");

        if (arrayNome.length <= 1) {
            throw new AtorException("Deve ser informado no mínimo nome e sobrenome para o diretor.");
        }
    }

    public void verificaDataNascimento(DiretorRequest diretorRequest) throws AtorException {

        LocalDate dataAtual = LocalDate.now();
        LocalDate dataNascimento = diretorRequest.getDataNascimento();
        boolean comparaDatas = dataNascimento.isAfter(dataAtual);

        if (comparaDatas) {
            throw new AtorException("Não é possível cadastrar diretores não nascidos.");
        }
    }

    public void verificaMesmoNome(DiretorRequest diretorRequest) throws AtorException {

        List<Diretor> listaNomes = fakeDatabase.recuperaDiretores();
        String nomeRequerido = diretorRequest.getNome();

        for (int i = 0; i < listaNomes.size(); i++) {
            if (listaNomes.get(i).getNome().contains(nomeRequerido)) {
                throw new AtorException("Já existe um diretor cadastrado para o nome " + diretorRequest.getNome());
            }
        }
    }

    public void setId() {
        List<Diretor> listaId = fakeDatabase.recuperaDiretores();

        Integer id = 1;
        diretor.setId(id);

        for (int i = 0; i < listaId.size(); i++) {
            if (diretor.getId() == listaId.get(i).getId()) {
                diretor.setId(id);
            }
        }
    }

    //...
}
