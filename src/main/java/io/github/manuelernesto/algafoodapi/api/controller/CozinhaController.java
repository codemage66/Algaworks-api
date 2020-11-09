package io.github.manuelernesto.algafoodapi.api.controller;

import io.github.manuelernesto.algafoodapi.api.model.CozinhasXMLWrapper;
import io.github.manuelernesto.algafoodapi.domain.model.Cozinha;
import io.github.manuelernesto.algafoodapi.domain.repository.CozinhaRepository;
import io.github.manuelernesto.algafoodapi.domain.services.CadastroCozinhaService;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    private final CozinhaRepository cozinhaRepository;
    private final CadastroCozinhaService service;

    public CozinhaController(CozinhaRepository repository, CadastroCozinhaService service) {
        this.cozinhaRepository = repository;
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cozinha> list() {
        return cozinhaRepository.findAll();
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public CozinhasXMLWrapper listXML() {
        return new CozinhasXMLWrapper(cozinhaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cozinha> find(@PathVariable Long id) {
        var cozinha = cozinhaRepository.findByID(id);
        if (cozinha != null)
            return ResponseEntity.ok(cozinha);

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha save(@RequestBody Cozinha cozinha) {
        return service.save(cozinha);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cozinha> update(@PathVariable Long id, @RequestBody Cozinha cozinha) {
        var cozinhaActual = cozinhaRepository.findByID(id);
        if (cozinhaActual != null) {
            BeanUtils.copyProperties(cozinha, cozinhaActual, "id");
            cozinhaActual = cozinhaRepository.add(cozinhaActual);
            return ResponseEntity.ok(cozinhaActual);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cozinha> delete(@PathVariable Long id) {
        try {
            var cozinha = cozinhaRepository.findByID(id);
            if (cozinha != null) {
                cozinhaRepository.remove(cozinha);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

}







