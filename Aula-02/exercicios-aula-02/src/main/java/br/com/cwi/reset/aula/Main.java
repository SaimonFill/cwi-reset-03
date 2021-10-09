package br.com.cwi.reset.aula;

public class Main {
    public static void main(String[] args) {

        System.out.println("Filme 1");
        Filme filme1 = new Filme("Olhos Famintos", 120, "Terror", "1998",
                4, "José", 45, 10);
        filme1.reproduzir();

        System.out.println("\nFilme 2");
        Filme filme2 = new Filme("Marley e Eu", 98, "Comédia", "2010",
                5, "Ana Maria", 32, 14);
        filme2.reproduzir();
    }
}
