package br.com.cwi.reset.primeiroprojetospring.domain;

public class Filme {

    private String nomeFilme;
    private Integer duracao;
    private String descricaoFilme;
    private Integer anoLancamento;
    private Integer avaliacao;
    private Diretor diretor;

    public Filme(String nomeFilme, Integer duracao, String descricaoFilme, Integer anoLancamento, Diretor diretor, Integer avaliacao) {
        this.nomeFilme = nomeFilme;
        this.duracao = duracao;
        this.descricaoFilme = descricaoFilme;
        this.anoLancamento = anoLancamento;
        this.diretor = diretor;
//        if (avaliacao > 5 || avaliacao < 1) {
//            throw new AvaliacaoForaDoPadraoException();
//        }
        this.avaliacao = avaliacao;
    }

    public void reproduzir() {
        System.out.println("Reproduzindo: " + nomeFilme
                + "\nDescrição: " + descricaoFilme
                + "\nDuração: " + duracao + "min"
                + "\nAvaliação: " + avaliacao);
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public String getDescricaoFilme() {
        return descricaoFilme;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public void setDescricaoFilme(String descricaoFilme) {
        this.descricaoFilme = descricaoFilme;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public void setAvaliacao(Integer avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }
}
