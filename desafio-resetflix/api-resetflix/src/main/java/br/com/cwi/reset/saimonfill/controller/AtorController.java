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

    //Resolver erro: Não encontra ator pelo nome
    @GetMapping("/em_atividade/{filtroNome}")
    @ResponseStatus(HttpStatus.OK)
    public List<AtorEmAtividade> listarAtoresEmAtividade(@PathVariable String filtroNome) throws Exception {
        return atorService.listarAtoresEmAtividade(java.util.Optional.of(""));
    }

    //Resolver erro: Não reconhece id null
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Ator consultarAtor(@PathVariable Integer id) throws Exception {
        return atorService.consultarAtor(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Ator> consultarAtores() throws Exception {
        return atorService.consultarAtores();
    }

    //demais métodos

}
