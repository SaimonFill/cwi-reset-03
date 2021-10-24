package br.com.cwi.reset.saimonfill.service;

import br.com.cwi.reset.saimonfill.FakeDatabase;
import br.com.cwi.reset.saimonfill.exception.*;
import br.com.cwi.reset.saimonfill.model.Ator;
import br.com.cwi.reset.saimonfill.model.StatusCarreira;
import br.com.cwi.reset.saimonfill.request.AtorRequest;
import br.com.cwi.reset.saimonfill.response.AtorEmAtividade;
import br.com.cwi.reset.saimonfill.validator.BasicInfoRequiredValidator;

import java.util.*;

public class AtorService {

    private FakeDatabase fakeDatabase;
    private Ator ator;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void criarAtor(AtorRequest atorRequest) throws Exception {

        new BasicInfoRequiredValidator().accept(
                atorRequest.getNome(),
                atorRequest.getDataNascimento(),
                atorRequest.getAnoInicioAtividade(),
                TipoDominioException.ATOR
        );

        verificaMesmoNome(atorRequest);

        List<Ator> atores = fakeDatabase.recuperaAtores();
        final Integer idGerado = atores.size() + 1;

        for (Ator atorCadastrado : atores) {
            if (atorCadastrado.getNome().equalsIgnoreCase(atorRequest.getNome())) {
                throw new JaExisteCadastradoException(TipoDominioException.ATOR.getSingular(), atorRequest.getNome());
            }
        }
        final Ator ator = new Ator(
                idGerado,
                atorRequest.getNome(),
                atorRequest.getDataNascimento(),
                atorRequest.getStatusCarreira(),
                atorRequest.getAnoInicioAtividade()
        );

        fakeDatabase.persisteAtor(ator);
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

    public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome) throws Exception {

        List<Ator> atores = fakeDatabase.recuperaAtores();
        StatusCarreira filtroCarreira = StatusCarreira.EM_ATIVIDADE;
        List<AtorEmAtividade> atorEmAtividade = new ArrayList<>();

        if (atores.isEmpty()) {
            throw new ListaVaziaException("ator", "atores");
        }
        else if (filtroNome != null) {
            for (int i = 0; i < atores.size(); i++) {

                boolean containsFiltro = atores.get(i).getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT));
                boolean filtroAtividade = atores.get(i).getStatusCarreira().equals(filtroCarreira);

                if (containsFiltro == true && filtroAtividade == true) {
                    atorEmAtividade.add(new AtorEmAtividade(
                            atores.get(i).getId(),
                            atores.get(i).getNome(),
                            atores.get(i).getDataNascimento())
                    );
                }
            }
        } else {
            for (int i = 0; i < atores.size(); i++) {

                boolean filtroAtividade = atores.get(i).getStatusCarreira().equals(filtroCarreira);

                if (filtroAtividade == true) {
                    atorEmAtividade.add(new AtorEmAtividade(
                            atores.get(i).getId(),
                            atores.get(i).getNome(),
                            atores.get(i).getDataNascimento())
                    );
                }
            }
        }

        if (atorEmAtividade.isEmpty()) {
            throw new FiltroNomeNaoEncontradoException("Ator", filtroNome);
        }

        return atorEmAtividade;
    }

    public Ator consultarAtor(Integer id) throws Exception {

        List<Ator> atores = fakeDatabase.recuperaAtores();

        if (id == null) {
            throw new CampoNaoInformadoException("id");
        }

        return atores.stream().filter(x -> x.getId().equals(id)).findAny().
                orElseThrow(() -> new ConsultarPeloIdException("ator", id));
    }

    public List<Ator> consultarAtores() throws Exception {

        List<Ator> atores = fakeDatabase.recuperaAtores();

        if (atores.isEmpty()) {
            throw new ListaVaziaException("ator", "atores");
        }

        return atores;
    }

}