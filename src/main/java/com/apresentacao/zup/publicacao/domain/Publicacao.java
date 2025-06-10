package com.apresentacao.zup.publicacao.domain;

import com.apresentacao.zup.publicacao.repository.entity.PublicacaoEntity;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Publicacao {

    private String id;
    private String titulo;
    private String imagemUrl;
    private String texto;
    private List<Comentario> comentarios;

    public Publicacao() {
    }

    public Publicacao(String id, String titulo, String imagemUrl, String texto, List<Comentario> comentarios) {
        this.id = id;
        this.titulo = titulo;
        this.imagemUrl = imagemUrl;
        this.texto = texto;
        this.comentarios = comentarios;
    }

    public PublicacaoEntity toPublicacaoEntity() {
        return new PublicacaoEntity(id, titulo, imagemUrl, texto, comentarios);
    }

    public String getId() {
        return id;
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

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
