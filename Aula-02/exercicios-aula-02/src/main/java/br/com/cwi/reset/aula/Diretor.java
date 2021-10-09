package br.com.cwi.reset.aula;

public class Diretor extends Pessoa{
    private Integer qtdFilmesDirigidos;

    public Diretor(String nome, Integer idade, Genero genero, Integer qtdFilmesDirigidos) {
        super(nome, idade, genero);
        this.qtdFilmesDirigidos = qtdFilmesDirigidos;
    }

    public Integer getQtdFilmesDirigidos() {
        return qtdFilmesDirigidos;
    }

    @Override
    public void caracteristica() {
        super.caracteristica();
        System.out.print(" filmes dirigidos "+ qtdFilmesDirigidos);
    }
}
