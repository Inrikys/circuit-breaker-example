package com.apresentacao.zup.publicacao.domain;

public class Comentario {

    private String autor;
    private String texto;

    public Comentario() {
    }

    public Comentario(String autor, String texto) {
        this.autor = autor;
        this.texto = texto;
    }

    public String getAutor() {
        return autor;
    }

    public String getTexto() {
        return texto;
    }
}
