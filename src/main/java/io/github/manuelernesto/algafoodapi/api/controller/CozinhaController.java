package io.github.manuelernesto.algafoodapi.api.controller;

import io.github.manuelernesto.algafoodapi.api.model.CozinhasXMLWrapper;
import io.github.manuelernesto.algafoodapi.domain.model.Cozinha;
import io.github.manuelernesto.algafoodapi.domain.repository.CozinhaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    private final CozinhaRepository repository;

    public CozinhaController(CozinhaRepository repository) {
        this.repository = repository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cozinha> list() {
        return repository.findAll();
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public CozinhasXMLWrapper listXML() {
        return new CozinhasXMLWrapper(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cozinha> find(@PathVariable Long id) {
        var cozinha = repository.findByID(id);
        if (cozinha != null)
            return ResponseEntity.ok(cozinha);

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha save(@RequestBody Cozinha cozinha) {
        return repository.add(cozinha);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cozinha> update(@PathVariable Long id, @RequestBody Cozinha cozinha) {
        var cozinhaActual = repository.findByID(id);
        if (cozinhaActual != null) {
            BeanUtils.copyProperties(cozinha, cozinhaActual, "id");
            cozinhaActual = repository.add(cozinhaActual);
            return ResponseEntity.ok(cozinhaActual);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cozinha> delete(@PathVariable Long id) {
        var cozinha = repository.findByID(id);
        if (cozinha != null) {
            repository.remove(cozinha);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}







