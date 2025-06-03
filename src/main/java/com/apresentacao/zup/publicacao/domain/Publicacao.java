package com.apresentacao.zup.publicacao.domain;

import com.apresentacao.zup.publicacao.repository.entity.PublicacaoEntity;

import java.util.List;

public class Publicacao {

    private String titulo;
    private String imagemUrl;
    private String texto;
    private List<Comentario> comentarios;

    public Publicacao() {
    }

    public Publicacao(String titulo, String imagemUrl, String texto, List<Comentario> comentarios) {
        this.titulo = titulo;
        this.imagemUrl = imagemUrl;
        this.texto = texto;
        this.comentarios = comentarios;
    }

    public PublicacaoEntity toPublicacaoEntity() {
        return new PublicacaoEntity(null, titulo, imagemUrl, texto, comentarios);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public String getTexto() {
        return texto;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }
}
