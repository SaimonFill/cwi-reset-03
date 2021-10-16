package br.com.cwi.reset.primeiroprojetospring.controller;

import br.com.cwi.reset.primeiroprojetospring.domain.AvaliacaoForaDoPadraoException;
import br.com.cwi.reset.primeiroprojetospring.domain.Diretor;
import br.com.cwi.reset.primeiroprojetospring.domain.Filme;
import br.com.cwi.reset.primeiroprojetospring.domain.Genero;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filme")

public class FilmeController {

    private static List<Filme> filmes = new ArrayList<>();

    public FilmeController() throws AvaliacaoForaDoPadraoException {
    }

    @GetMapping
    public List<Filme> getFilme() {
        return filmes;
    }

    @PostMapping
    public Filme cadastrarFilme(@RequestBody Filme filme) {
        filmes.add(filme);
        return filme;
    }
}
