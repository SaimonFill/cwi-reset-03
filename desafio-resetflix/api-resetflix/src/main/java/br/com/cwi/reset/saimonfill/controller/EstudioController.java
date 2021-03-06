package br.com.cwi.reset.saimonfill.controller;


import br.com.cwi.reset.saimonfill.FakeDatabase;
import br.com.cwi.reset.saimonfill.exception.CampoNaoInformadoException;
import br.com.cwi.reset.saimonfill.model.Estudio;
import br.com.cwi.reset.saimonfill.request.EstudioRequest;
import br.com.cwi.reset.saimonfill.service.EstudioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudios")
public class EstudioController {

    private EstudioService estudioService;
    private static List<Estudio> estudios = new ArrayList<>();

    public EstudioController() {
        this.estudioService = new EstudioService(FakeDatabase.getInstance());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarEstudio(@RequestBody EstudioRequest estudioRequest) throws Exception {
        this.estudioService.criarEstudio(estudioRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Estudio> consultarEstudios(@RequestParam String filtroNome) throws Exception {
       return this.estudioService.consultarEstudios(filtroNome);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Estudio consultarEstudio(@PathParam("/{id}") Integer id) throws Exception {

        if (id == null) {
            throw new CampoNaoInformadoException("id");
        }
        return this.estudioService.consultarEstudio(id);
    }
}
