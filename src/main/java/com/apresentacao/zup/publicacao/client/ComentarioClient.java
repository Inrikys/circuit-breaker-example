package com.apresentacao.zup.publicacao.client;

import com.apresentacao.zup.publicacao.domain.Comentario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ComentarioClient", url = "${client.comentarios.url}")
public interface ComentarioClient {

    @GetMapping("/comentarios/{publicacaoId}")
    List<Comentario> getComentarios(@PathVariable String publicacaoId);

}
