package com.apresentacao.zup.publicacao.service;

import com.apresentacao.zup.publicacao.domain.Comentario;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;
import java.util.List;

@Service
public class RedisService {

    private final RedisTemplate<String, Object> redisTemplate;

    public RedisService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void save(List<Comentario> comentarios, String id) {
        redisTemplate.opsForHash().put("Comentario", id, comentarios);
    }

    public List<Comentario> findByPublicacaoId(String publicacaoId) {
        return (List<Comentario>) redisTemplate.opsForHash().get("Comentario", publicacaoId);
    }
}
