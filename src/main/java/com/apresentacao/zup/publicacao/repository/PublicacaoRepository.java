package com.apresentacao.zup.publicacao.repository;

import com.apresentacao.zup.publicacao.repository.entity.PublicacaoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacaoRepository extends MongoRepository<PublicacaoEntity, String> {
}
