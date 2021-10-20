package br.com.cwi.reset.saimonfill.model;

import java.util.List;

public class Filme {

    private Integer id;
    private String nome;
    private Integer anoLancamento;
    private String capaFilme;
    private List<Genero> genero;
    private Diretor idDiretor;
    private Estudio idEstudio;
    private List<PersonagemAtor> personagens;

    public Filme(Integer id, String nome, Integer anoLancamento, String capaFilme, List<Genero> genero, Diretor idDiretor, Estudio idEstudio, List<PersonagemAtor> personagens) {
        this.id = id;
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.capaFilme = capaFilme;
        this.genero = genero;
        this.idDiretor = idDiretor;
        this.idEstudio = idEstudio;
        this.personagens = personagens;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id += id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getCapaFilme() {
        return capaFilme;
    }

    public void setCapaFilme(String capaFilme) {
        this.capaFilme = capaFilme;
    }

    public List<Genero> getGenero() {
        return genero;
    }

    public void setGenero(List<Genero> genero) {
        this.genero = genero;
    }

    public Diretor getIdDiretor() {
        return idDiretor;
    }

    public void setIdDiretor(Diretor idDiretor) {
        this.idDiretor = idDiretor;
    }

    public Estudio getIdEstudio() {
        return idEstudio;
    }

    public void setIdEstudio(Estudio idEstudio) {
        this.idEstudio = idEstudio;
    }

    public List<PersonagemAtor> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<PersonagemAtor> personagens) {
        this.personagens = personagens;
    }
}
