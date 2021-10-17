package br.com.cwi.reset.saimonfill.service;

import br.com.cwi.reset.saimonfill.FakeDatabase;
import br.com.cwi.reset.saimonfill.exception.*;
import br.com.cwi.reset.saimonfill.model.Diretor;
import br.com.cwi.reset.saimonfill.request.DiretorRequest;

import java.time.LocalDate;
import java.util.List;

public class DiretorService {

    private FakeDatabase fakeDatabase;
    private Diretor diretor;

    public DiretorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void cadastrarDiretor(DiretorRequest diretorRequest) throws Exception {

        verificaCamposObrigatorios(diretorRequest);
        verificaNomeSobrenome(diretorRequest);
        verificaMesmoNome(diretorRequest);
        verificaDataNascimento(diretorRequest);
        verificaAnoInicioAtividade(diretorRequest);

        diretor = new Diretor(
                diretorRequest.getNome(),
                diretorRequest.getDataNascimento(),
                diretorRequest.getAnoInicioAtividade()
        );

        setId();
        fakeDatabase.persisteDiretor(diretor);
    }

    public void verificaCamposObrigatorios(DiretorRequest diretorRequest) throws Exception {

        if (diretorRequest.getNome().isEmpty()) {
            throw new NomeNaoInformadoException();
        }
        if (diretorRequest.getDataNascimento() == null) {
            throw new DataNascimentoNaoInformadoException();
        }
        if (diretorRequest.getAnoInicioAtividade() == null) {
            throw new AnoInicioAtividadeNaoInformadoException();
        }
    }

    public void verificaNomeSobrenome(DiretorRequest diretorRequest) throws Exception {

        String nome = diretorRequest.getNome();
        String[] arrayNome = nome.split(" ");

        if (arrayNome.length <= 1) {
            throw new InformarNomeSobrenomeException("diretor");
        }
    }

    public void verificaDataNascimento(DiretorRequest diretorRequest) throws Exception {

        LocalDate dataAtual = LocalDate.now();
        LocalDate dataNascimento = diretorRequest.getDataNascimento();
        boolean comparaDatas = dataNascimento.isAfter(dataAtual);

        if (comparaDatas) {
            throw new NaoCadastrarNaoNacidosException("diretor");
        }
    }

    public void verificaMesmoNome(DiretorRequest diretorRequest) throws Exception {

        List<Diretor> listaNomes = fakeDatabase.recuperaDiretores();
        String nomeRequerido = diretorRequest.getNome();

        for (int i = 0; i < listaNomes.size(); i++) {
            if (listaNomes.get(i).getNome().contains(nomeRequerido)) {
                throw new JaExisteCadastradoException("diretor", nomeRequerido);
            }
        }
    }

    public void verificaAnoInicioAtividade(DiretorRequest diretorRequest) throws Exception {

        LocalDate dataNascimento = diretorRequest.getDataNascimento();
        LocalDate inicioAtividade = LocalDate.ofYearDay(diretorRequest.getAnoInicioAtividade(), 1);

        boolean comparaDatas = dataNascimento.isAfter(inicioAtividade);

        if (comparaDatas) {
            throw new AnoInicioInvalidoException("diretor");
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
