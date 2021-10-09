package br.com.cwi.reset.aula;

public class Filme {

    private String nomeFilme;
    private Integer duracao;
    private String descricaoFilme;
    private Integer anoLancamento;
    private Integer avaliacao;
    private Diretor diretor;

    public Filme(String nomeFilme, Integer duracao, String descricaoFilme, Integer anoLancamento, Integer avaliacao, Diretor diretor) {
        this.nomeFilme = nomeFilme;
        this.duracao = duracao;
        this.descricaoFilme = descricaoFilme;
        this.anoLancamento = anoLancamento;
        this.avaliacao = avaliacao;
        this.diretor = diretor;
    }

    public void reproduzir() {
        System.out.println("Reproduzindo: " + nomeFilme
                + "\nDescrição: " + descricaoFilme
                + "\nDuração: " + duracao + "min");
    }
}
