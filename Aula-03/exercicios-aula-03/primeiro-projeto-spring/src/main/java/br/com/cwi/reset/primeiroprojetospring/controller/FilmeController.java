package br.com.cwi.reset.primeiroprojetospring.controller;

import br.com.cwi.reset.primeiroprojetospring.domain.AvaliacaoForaDoPadraoException;
import br.com.cwi.reset.primeiroprojetospring.domain.Filme;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filme")

public class FilmeController {

    private static List<Filme> filmes = new ArrayList<>();

    public FilmeController() throws AvaliacaoForaDoPadraoException {
    }

    @GetMapping
    public List<Filme> getListaFilmes() {
        return filmes;
    }

    @PostMapping
    public ResponseEntity<Filme> cadastrarFilme(@RequestBody Filme filme) {
        Filme filmeExistente = buscaFilmePeloNome(filme.getNome());

        if (filmeExistente != null) {
            return ResponseEntity.badRequest().build();
        }
        filmes.add(filme);
        return ResponseEntity.ok(filme);
    }

    @DeleteMapping("/{nome}")
    public void deletarFilme(@PathVariable String nome) {
        Filme filme = buscaFilmePeloNome(nome);

        if (filme != null) {
            filmes.remove(filme);
        }
    }

    @PutMapping
    public Filme atualizarFilme(@RequestBody Filme filme) {
        Filme filmeExistente = buscaFilmePeloNome(filme.getNome());

        if (filmeExistente != null) {
            filmes.remove(filmeExistente);
            filmes.add(filme);
            return filme;
        }
        return null;
    }

    private Filme buscaFilmePeloNome(String nome) {
        for (Filme filme : filmes) {
            if (filme.getNome().equals(nome)) {
                return filme;
            }
        }
        return null;
    }
}
