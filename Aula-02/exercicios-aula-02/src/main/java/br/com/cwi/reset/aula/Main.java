package br.com.cwi.reset.aula;

public class Main {
    public static void main(String[] args) {

        System.out.println("Filme 1");
        Diretor diretor = new Diretor("José", 51, 50, Genero.MASCULINO);
        Ator ator = new Ator("Natalia", 25, 4, Genero.FEMININO);
        Filme filme1 = new Filme("Olhos Famintos", 120, "Terror", 1998, 4, diretor);
        ator.caracteristica();

        filme1.reproduzir();
        diretor.caracteristica();

        System.out.println("\nFilme 2");
        Filme filme2 = new Filme("Marley e Eu", 98, "Comédia", 2010, 5, diretor);
        filme2.reproduzir();
    }
}
