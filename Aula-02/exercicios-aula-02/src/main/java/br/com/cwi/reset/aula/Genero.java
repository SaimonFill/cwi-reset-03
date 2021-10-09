package br.com.cwi.reset.aula;

public enum Genero {
    MASCULINO("Masculino"),
    FEMININO("Feminimo"),
    NAO_BINARIO("Não Binario");

    private String descricao;

    Genero(String descricao){
        this.descricao = descricao;
    }
}
