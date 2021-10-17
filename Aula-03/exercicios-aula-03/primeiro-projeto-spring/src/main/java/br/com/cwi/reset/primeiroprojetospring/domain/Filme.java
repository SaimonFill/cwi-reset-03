package br.com.cwi.reset.primeiroprojetospring.domain;

public class Filme {

    private String nome;
    private Integer duracao;
    private String descricaoFilme;
    private Integer anoLancamento;
    private Integer avaliacao;
    private Diretor diretor;

    public Filme(String nome, Integer duracao, String descricaoFilme, Integer anoLancamento, Diretor diretor, Integer avaliacao) throws AvaliacaoForaDoPadraoException {
        this.nome = nome;
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
        System.out.println("Reproduzindo: " + nome
                + "\nDescrição: " + descricaoFilme
                + "\nDuração: " + duracao + "min"
                + "\nAvaliação: " + avaliacao);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public String getDescricaoFilme() {
        return descricaoFilme;
    }

    public void setDescricaoFilme(String descricaoFilme) {
        this.descricaoFilme = descricaoFilme;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Integer avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }
}
