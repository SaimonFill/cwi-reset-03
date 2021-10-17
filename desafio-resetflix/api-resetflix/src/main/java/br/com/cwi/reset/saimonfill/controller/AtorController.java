package br.com.cwi.reset.saimonfill.controller;

import br.com.cwi.reset.saimonfill.FakeDatabase;
import br.com.cwi.reset.saimonfill.model.Ator;
import br.com.cwi.reset.saimonfill.request.AtorRequest;
import br.com.cwi.reset.saimonfill.response.AtorEmAtividade;
import br.com.cwi.reset.saimonfill.service.AtorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atores")
public class AtorController {

    private AtorService atorService;

    public AtorController() {
        this.atorService = new AtorService(FakeDatabase.getInstance());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAtor(@RequestBody AtorRequest atorRequest) throws Exception {
        this.atorService.criarAtor(atorRequest);
    }

    @GetMapping("/{em_atividade}")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome) throws Exception {
        return atorService.listarAtoresEmAtividade(java.util.Optional.of(""));
    }

    //demais métodos

}
