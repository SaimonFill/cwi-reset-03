package br.com.cwi.reset.saimonfill;

public enum StatusAtividade {

    EM_ATIVIDADE("Em atividade"),
    ENCERRADO("Encerrado");

    private String statusAtividade;

    StatusAtividade(String statusAtividade) {
        this.statusAtividade = statusAtividade;
    }

    public String getStatusAtividade() {
        return statusAtividade;
    }
}
