package com.apresentacao.zup.publicacao.controler.request;

import com.apresentacao.zup.publicacao.domain.Publicacao;
import jakarta.validation.constraints.NotBlank;

public class PublicacaoRequest {

    @NotBlank
    private String titulo;

    private String imagemUrl;

    @NotBlank
    private String texto;

    public PublicacaoRequest() {
    }

    public PublicacaoRequest(String titulo, String imagemUrl, String texto) {
        this.titulo = titulo;
        this.imagemUrl = imagemUrl;
        this.texto = texto;
    }

    public Publicacao toPublicacao() {
        return new Publicacao(null, titulo, imagemUrl, texto, null);
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
}
