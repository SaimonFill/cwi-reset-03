package br.com.cwi.reset.saimonfill.service;

import br.com.cwi.reset.saimonfill.FakeDatabase;
import br.com.cwi.reset.saimonfill.exception.*;
import br.com.cwi.reset.saimonfill.model.Diretor;
import br.com.cwi.reset.saimonfill.request.DiretorRequest;
import br.com.cwi.reset.saimonfill.validator.BasicInfoRequiredValidator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class DiretorService {

    private FakeDatabase fakeDatabase;
    private Diretor diretor;

    public DiretorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void cadastrarDiretor(DiretorRequest diretorRequest) throws Exception {

        new BasicInfoRequiredValidator().accept(
                diretorRequest.getNome(),
                diretorRequest.getDataNascimento(),
                diretorRequest.getAnoInicioAtividade(),
                TipoDominioException.DIRETOR
        );

        verificaNomeSobrenome(diretorRequest);

        List<Diretor> diretorSize = fakeDatabase.recuperaDiretores();

        diretor = new Diretor(
                diretorRequest.getNome(),
                diretorRequest.getDataNascimento(),
                diretorRequest.getAnoInicioAtividade()
        );

        fakeDatabase.persisteDiretor(diretor);
    }

    public void verificaNomeSobrenome(DiretorRequest diretorRequest) throws Exception {

        String nome = diretorRequest.getNome();
        String[] arrayNome = nome.split(" ");

        if (arrayNome.length <= 1) {
            throw new InformarNomeSobrenomeException("diretor");
        }
    }

    public List<Diretor> listarDiretores(String filtroNome) throws Exception {

        List<Diretor> diretores = fakeDatabase.recuperaDiretores();
        List<Diretor> diretorEncontrado = new ArrayList<>();

        if (diretores.isEmpty()) {
            throw new ListaVaziaException("diretor", "diretores");
        }

        if (filtroNome != null) {
            for (int i = 0; i < diretores.size(); i++) {

                boolean containsFiltro = diretores.get(i).getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT));

                if (containsFiltro == true) {
                    diretorEncontrado.add(diretores.get(i));
                }
            }
        }
        else {
            diretorEncontrado.addAll(diretores);
        }

        return diretorEncontrado;
    }

    public Diretor consultarDiretor(Integer id) throws Exception {

        List<Diretor> diretores = fakeDatabase.recuperaDiretores();

        if (id == null) {
            throw new CampoNaoInformadoException("id");
        }

        return diretores.stream().filter(x -> x.getId().equals(id)).findAny().
                orElseThrow(() -> new ConsultarPeloIdException("diretor", id));
    }

}
