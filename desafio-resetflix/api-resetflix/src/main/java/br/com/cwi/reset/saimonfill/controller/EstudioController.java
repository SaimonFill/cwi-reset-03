package br.com.cwi.reset.saimonfill.controller;


import br.com.cwi.reset.saimonfill.FakeDatabase;
import br.com.cwi.reset.saimonfill.request.EstudioRequest;
import br.com.cwi.reset.saimonfill.service.AtorService;
import br.com.cwi.reset.saimonfill.service.EstudioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estudios")
public class EstudioController {

    private EstudioService estudioService;

    public EstudioController() {
        this.estudioService = new EstudioService(FakeDatabase.getInstance());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarEstudio(EstudioRequest estudioRequest) {
        this.estudioService.criarEstudio(estudioRequest);
    }
}
