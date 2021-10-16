package br.com.cwi.reset.primeiroprojetospring.controller;

import br.com.cwi.reset.primeiroprojetospring.domain.Diretor;
import br.com.cwi.reset.primeiroprojetospring.domain.Filme;
import br.com.cwi.reset.primeiroprojetospring.domain.Genero;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;

@RestController
@RequestMapping("/filme")

public class FilmeController {

    private Diretor diretor = new Diretor(
            "Saimon",
            LocalDate.of(1996, Month.NOVEMBER, 15),
            Genero.MASCULINO,
            5
    );

    private  Filme filme = new Filme(
            "Teste",
            90,
            "Testando primeiro projeto Spring",
            2021,
            diretor,
            10
    );

    @GetMapping
    public Filme getFilme() {
        return filme;
    }

//    @GetMapping
//    public String getHelloWorld() {
//        return "Hello World!";
//    }
}
