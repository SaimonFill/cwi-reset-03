package br.com.cwi.reset.aula;

public class Ator extends Pessoa{
    private Integer oscars;

    public Ator(String nome, Integer idade, Genero genero, Integer oscars) {
        super(nome, idade, genero);
        this.oscars = oscars;
    }

    @Override
    public void caracteristica() {
        super.caracteristica();
        System.out.print(" Oscars " + oscars);
    }
}
