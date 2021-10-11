package br.com.cwi.reset.saimonfill;

public enum Genero {

    ACAO("Ação"),
    AVENTURA("Aventura"),
    COMEDIA("Comédia"),
    DOCUMENTARIO("Documentário"),
    DRAMA("Drama"),
    ESPIONAGEM("Espionagem"),
    FICCAO_CIENTIFICA("Ficão Cientifica"),
    GUERRA("Guerra"),
    MISTERIO("Mistério"),
    MUSICAL("Musical"),
    POLICIAL("Policial"),
    ROMANCE("Romance"),
    TERROR("Terror");

    private String genero;

    Genero(String genero) {
        this.genero = genero;
    }

    public String getGenero(){
        return genero;
    }
}
