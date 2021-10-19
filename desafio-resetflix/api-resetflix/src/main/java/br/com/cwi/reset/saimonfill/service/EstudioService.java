package br.com.cwi.reset.saimonfill.service;

import br.com.cwi.reset.saimonfill.FakeDatabase;
import br.com.cwi.reset.saimonfill.model.Diretor;
import br.com.cwi.reset.saimonfill.model.Estudio;
import br.com.cwi.reset.saimonfill.request.EstudioRequest;

import java.util.List;

public class EstudioService {

    private FakeDatabase fakeDatabase;
    private Estudio estudio;

    public EstudioService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void criarEstudio(EstudioRequest estudioRequest) {

        estudio = new Estudio(
                estudioRequest.getNome(),
                estudioRequest.getDescricao(),
                estudioRequest.getDataCriacao(),
                estudioRequest.getStatusAtividade()
        );

        setId();
        fakeDatabase.persisteEstudio(estudio);
    }

    public void setId() {
        List<Estudio> listaId = fakeDatabase.recuperaEstudios();

        Integer id = 1;
        estudio.setId(id);

        for (int i = 0; i < listaId.size(); i++) {
            if (estudio.getId() == listaId.get(i).getId()) {
                estudio.setId(id);
            }
        }
    }
}
