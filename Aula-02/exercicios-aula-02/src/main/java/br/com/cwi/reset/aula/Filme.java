package br.com.cwi.reset.aula;

public class Filme {

    private String nomeFilme;
    private int duracao;
    private String descricaoFilme;
    private String anoLancamento;
    private int avaliacao;
    private String nomeDiretor;
    private int idadeDiretor;
    private int qtdFilmesDirigidos;

    public Filme(String nomeFilme, int duracao, String descricaoFilme, String anoLancamento, int avaliacao, String nomeDiretor, int idadeDiretor, int qtdFilmesDirigidos) {
        this.nomeFilme = nomeFilme;
        this.duracao = duracao;
        this.descricaoFilme = descricaoFilme;
        this.anoLancamento = anoLancamento;
        this.avaliacao = avaliacao;
        this.nomeDiretor = nomeDiretor;
        this.idadeDiretor = idadeDiretor;
        this.qtdFilmesDirigidos = qtdFilmesDirigidos;
    }

    public void reproduzir() {
        System.out.println("Reproduzindo: " + nomeFilme
                + "\nDescrição: " + descricaoFilme
                + "\nDuração: " + duracao + "min"
                + "\nDiretor: " + nomeDiretor);
    }
}
