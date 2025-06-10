package com.apresentacao.zup.publicacao.service;

import com.apresentacao.zup.publicacao.client.ComentarioClient;
import com.apresentacao.zup.publicacao.domain.Comentario;
import com.apresentacao.zup.publicacao.domain.Publicacao;
import com.apresentacao.zup.publicacao.handler.ApiExceptionHandler;
import com.apresentacao.zup.publicacao.repository.PublicacaoRepository;
import com.apresentacao.zup.publicacao.repository.entity.PublicacaoEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicacaoService {

    private static final Logger logger = LoggerFactory.getLogger(ApiExceptionHandler.class);

    private final PublicacaoRepository publicacaoRepository;
    private final ComentarioService comentarioService;

    public PublicacaoService(PublicacaoRepository publicacaoRepository, ComentarioService comentarioService) {
        this.publicacaoRepository = publicacaoRepository;
        this.comentarioService = comentarioService;
    }

    public void insert(Publicacao publicacao) {
        publicacaoRepository.save(publicacao.toPublicacaoEntity());
    }

    public List<Publicacao> findAll() {
        List<PublicacaoEntity> publicacoesEntity = publicacaoRepository.findAll();
        return publicacoesEntity.stream().map(PublicacaoEntity::toPublicacao).toList();
    }

    public Publicacao findById(String id) {
        Optional<PublicacaoEntity> possivelPublicacaoEntity = publicacaoRepository.findById(id);
        Publicacao publicacao = possivelPublicacaoEntity.map(PublicacaoEntity::toPublicacao).orElseThrow(RuntimeException::new);

        List<Comentario> comentarios = comentarioService.getComentariosByPublicacaoId(publicacao.getId());
        publicacao.setComentarios(comentarios);

        return publicacao;
    }


}
