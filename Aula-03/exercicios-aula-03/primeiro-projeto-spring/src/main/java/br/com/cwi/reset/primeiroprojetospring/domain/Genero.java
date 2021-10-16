package br.com.cwi.reset.primeiroprojetospring.domain;

public enum Genero {
    MASCULINO("Masculino"),
    FEMININO("Feminimo"),
    NAO_BINARIO("Não Binario");

    private String descricao;

    Genero(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
