package br.com.cwi.reset.saimonfill.service;

import br.com.cwi.reset.saimonfill.exception.*;
import br.com.cwi.reset.saimonfill.model.Ator;
import br.com.cwi.reset.saimonfill.model.StatusCarreira;
import br.com.cwi.reset.saimonfill.repository.AtorRepository;
import br.com.cwi.reset.saimonfill.request.AtorRequest;
import br.com.cwi.reset.saimonfill.response.AtorEmAtividade;
import br.com.cwi.reset.saimonfill.validator.BasicInfoRequiredValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AtorService {

    @Autowired
    private AtorRepository atorRepository;

    public void criarAtor(AtorRequest atorRequest) throws Exception {

        new BasicInfoRequiredValidator().accept(
                atorRequest.getNome(),
                atorRequest.getDataNascimento(),
                atorRequest.getAnoInicioAtividade(),
                TipoDominioException.ATOR
        );
        verificaMesmoNome(atorRequest);

        final Ator ator = new Ator(
                atorRequest.getNome(),
                atorRequest.getDataNascimento(),
                atorRequest.getStatusCarreira(),
                atorRequest.getAnoInicioAtividade()
        );

        atorRepository.save(ator);
    }

    public void verificaMesmoNome(AtorRequest atorRequest) throws Exception {

        Ator atorExistente = atorRepository.findByNome(atorRequest.getNome());

        if (atorExistente != null) {
            throw new JaExisteCadastradoException("ator", atorRequest.getNome());
        }
    }

    public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome) throws Exception {

        StatusCarreira filtroCarreira = StatusCarreira.EM_ATIVIDADE;

        if (atorRepository.findAll() == null) {
            throw new ListaVaziaException("ator", "atores");
        }

        if (filtroNome == null) {
            return atorRepository.findByStatusCarreira(filtroCarreira);
        }

        return atorRepository.findByNomeStartingWithIgnoreCaseAndStatusCarreira(filtroNome, filtroCarreira);
    }

    public Ator consultarAtor(Integer id) throws Exception {
        Ator atorId = atorRepository.findById(id).get();

        if (id == null) {
            throw new CampoNaoInformadoException("id");
        }

        if (atorId == null) {
            throw new ConsultarPeloIdException("ator", id);
        }

        return atorId;
    }

    public List<Ator> consultarAtores() throws Exception {

        if (atorRepository.findAll() == null) {
            throw new ListaVaziaException("ator", "atores");
        }

        return (List<Ator>) atorRepository.findAll();
    }

}