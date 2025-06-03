package com.apresentacao.zup.publicacao.controler;

import com.apresentacao.zup.publicacao.controler.request.PublicacaoRequest;
import com.apresentacao.zup.publicacao.domain.Publicacao;
import com.apresentacao.zup.publicacao.service.PublicacaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/publicacoes")
public class PublicacaoController {

    private final PublicacaoService service;

    public PublicacaoController(PublicacaoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@Valid @RequestBody PublicacaoRequest request) {
        service.insert(request.toPublicacao());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Publicacao> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publicacao findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

}
