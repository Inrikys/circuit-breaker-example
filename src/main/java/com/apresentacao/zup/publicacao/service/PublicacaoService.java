package com.apresentacao.zup.publicacao.service;

import com.apresentacao.zup.publicacao.domain.Publicacao;
import com.apresentacao.zup.publicacao.repository.PublicacaoRepository;
import com.apresentacao.zup.publicacao.repository.entity.PublicacaoEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicacaoService {

    private final PublicacaoRepository publicacaoRepository;

    public PublicacaoService(PublicacaoRepository publicacaoRepository) {
        this.publicacaoRepository = publicacaoRepository;
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
        return possivelPublicacaoEntity.map(PublicacaoEntity::toPublicacao).orElseThrow(RuntimeException::new);
    }

}
