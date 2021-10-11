package br.com.cwi.reset.saimonfill;

public enum TipoAtuacao {

    PRINCIPAL("Principal"),
    COADJUVANTE("Coadjuvante");

    private String tipoAtuacao;

    TipoAtuacao(String tipoAtuacao) {
        this.tipoAtuacao = tipoAtuacao;
    }

    public String getTipoAtuacao() {
        return tipoAtuacao;
    }
}
