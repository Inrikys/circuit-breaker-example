package com.apresentacao.zup.publicacao.repository.entity;

import com.apresentacao.zup.publicacao.domain.Comentario;
import com.apresentacao.zup.publicacao.domain.Publicacao;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document(collection = "publicacoes")
public class PublicacaoEntity {

    @MongoId
    private String id;
    private String titulo;
    private String imagemUrl;
    private String texto;
    private List<Comentario> comentarios;

    public PublicacaoEntity() {
    }

    public PublicacaoEntity(String id, String titulo, String imagemUrl, String texto, List<Comentario> comentarios) {
        this.id = id;
        this.titulo = titulo;
        this.imagemUrl = imagemUrl;
        this.texto = texto;
        this.comentarios = comentarios;
    }

    public Publicacao toPublicacao() {
        return new Publicacao(id, titulo, imagemUrl, texto, comentarios);
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
}
