package br.com.cwi.reset.aula;

public class Filme {

    private String nomeFilme;
    private Integer duracao;
    private String descricaoFilme;
    private Integer anoLancamento;
    private Integer avaliacao;
    private Diretor diretor;

    public Filme(String nomeFilme, Integer duracao, String descricaoFilme, Integer anoLancamento, Diretor diretor, Integer avaliacao) throws AvaliacaoForaDoPadraoException {
        this.nomeFilme = nomeFilme;
        this.duracao = duracao;
        this.descricaoFilme = descricaoFilme;
        this.anoLancamento = anoLancamento;
        this.diretor = diretor;
        if (avaliacao > 5 || avaliacao < 1) {
            throw new AvaliacaoForaDoPadraoException();
        }
        this.avaliacao = avaliacao;
    }

    public void reproduzir() {
        System.out.println("Reproduzindo: " + nomeFilme
                + "\nDescrição: " + descricaoFilme
                + "\nDuração: " + duracao + "min"
                + "\nAvaliação: " + avaliacao);
    }
}
