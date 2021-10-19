package br.com.cwi.reset.saimonfill.controller;

import br.com.cwi.reset.saimonfill.FakeDatabase;
import br.com.cwi.reset.saimonfill.model.Ator;
import br.com.cwi.reset.saimonfill.model.Diretor;
import br.com.cwi.reset.saimonfill.request.DiretorRequest;
import br.com.cwi.reset.saimonfill.service.DiretorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    private DiretorService diretorService;

    public DiretorController() {
        this.diretorService = new DiretorService(FakeDatabase.getInstance());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarDiretor(@RequestBody DiretorRequest diretorRequest) throws Exception {
        this.diretorService.cadastrarDiretor(diretorRequest);
    }

    //Resolver erro: Não encontra diretor pelo nome
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Diretor> listarDiretores(@PathVariable Optional<String> filtroNome) throws Exception {
        return diretorService.listarDiretores(Optional.of(""));
    }

    //Resolver erro: Não reconhece id null
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Diretor consultarDiretor(@PathVariable Integer id) throws Exception {
        return diretorService.consultarDiretor(id);
    }
}
