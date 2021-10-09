package br.com.cwi.reset.aula;

public class Ator {
    private String nome;
    private Integer idade;
    private Integer oscars;
    private Genero genero;

    public Ator(String nome, Integer idade, Integer oscars, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.oscars = oscars;
        this.genero = genero;
    }

    public void caracteristica(){
        System.out.println("Ator " + nome + ", " + idade + " anos, " + genero + " ,Oscars ganhos: " + oscars);
    }

}
