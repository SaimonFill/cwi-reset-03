package br.com.cwi.reset.aula;

public class Diretor {
    private String nome;
    private Integer idade;
    private Integer qtdFilmesDirigidos;
    private Genero genero;

    public Diretor(String nome, Integer idade, Integer qtdFilmesDirigidos, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.qtdFilmesDirigidos = qtdFilmesDirigidos;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public Integer getQtdFilmesDirigidos() {
        return qtdFilmesDirigidos;
    }

    public void caracteristica(){
        System.out.println("Diretor: " + nome + ", " + idade + " anos, " + genero);
    }
}
