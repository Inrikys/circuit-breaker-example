package com.apresentacao.zup.publicacao.service;

import com.apresentacao.zup.publicacao.client.ComentarioClient;
import com.apresentacao.zup.publicacao.domain.Comentario;
import com.apresentacao.zup.publicacao.handler.ApiExceptionHandler;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    private static final Logger logger = LoggerFactory.getLogger(ApiExceptionHandler.class);

    private final ComentarioClient comentarioClient;
    private final RedisService redisService;

    public ComentarioService(ComentarioClient comentarioClient, RedisService redisService) {
        this.comentarioClient = comentarioClient;
        this.redisService = redisService;
    }

    @CircuitBreaker(name = "comentarios", fallbackMethod = "getComentariosByPublicacaoIdFallback")
    public List<Comentario> getComentariosByPublicacaoId(String id) {
        List<Comentario> comentarios = comentarioClient.getComentarios(id);
        redisService.save(comentarios, id);
        return comentarios;
    }

    // Fallback deve conter mesma assinatura que @CircuitBreaker + Throwable
    private List<Comentario> getComentariosByPublicacaoIdFallback(String id, Throwable throwable) {
        logger.warn("[WARN] fallback with id {}", id);
        return redisService.findByPublicacaoId(id);
    }

}
