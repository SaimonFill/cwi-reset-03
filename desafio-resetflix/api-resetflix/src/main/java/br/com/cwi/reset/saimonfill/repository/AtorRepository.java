package br.com.cwi.reset.saimonfill.repository;

import br.com.cwi.reset.saimonfill.model.Ator;
import br.com.cwi.reset.saimonfill.model.StatusCarreira;
import br.com.cwi.reset.saimonfill.response.AtorEmAtividade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtorRepository extends CrudRepository<Ator, Integer> {

    Ator findByNome(String nome);

    List<AtorEmAtividade> findByStatusCarreira(StatusCarreira filtroCarreira);

    List<AtorEmAtividade> findByNomeStartingWithIgnoreCaseAndStatusCarreira(String filtroNome, StatusCarreira filtroCarreira);
}
