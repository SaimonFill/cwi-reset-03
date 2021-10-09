package br.com.cwi.reset.aula;

public class Main {
    public static void main(String[] args) {

        Ator ator = new Ator("Pedro", 33, Genero.MASCULINO, 10);
        ator.caracteristica();

        Diretor diretor = new Diretor("João", 45, Genero.MASCULINO, 8);
        diretor.caracteristica();
    }
}
