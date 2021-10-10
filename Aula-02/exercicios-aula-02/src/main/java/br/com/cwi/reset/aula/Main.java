package br.com.cwi.reset.aula;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws AvaliacaoForaDoPadraoException {

        Diretor diretor = new Diretor("Teste Diretor", LocalDate.of(1996, 11, 15), Genero.FEMININO, 10);
        diretor.caracteristica();

        Ator ator = new Ator("Teste Ator", LocalDate.of(2000, 7, 8), Genero.FEMININO, 4);
        ator.caracteristica();

        Filme filme = new Filme("Teste Filme", 90, "Comédia", 2015, diretor, 0);
        filme.reproduzir();

    }
}
