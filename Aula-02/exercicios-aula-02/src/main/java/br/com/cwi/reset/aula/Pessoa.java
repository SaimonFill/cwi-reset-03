package br.com.cwi.reset.aula;

public class Pessoa {

    private String nome;
    private Integer idade;
    private Genero genero;

    public Pessoa(String nome, Integer idade, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
    }

    public void caracteristica(){
        System.out.print("\nAtor " + nome + ", " + idade + " anos, " + genero.getDescricao());
    }
}
