package io.github.manuelernesto.algafoodapi.api.controller;

import io.github.manuelernesto.algafoodapi.api.model.CozinhasXMLWrapper;
import io.github.manuelernesto.algafoodapi.domain.exception.EntityInUseException;
import io.github.manuelernesto.algafoodapi.domain.exception.EntityNotFoundException;
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
    private final CadastroCozinhaService cozinhaService;

    public CozinhaController(CozinhaRepository cozinhaRepository, CadastroCozinhaService cozinhaService) {
        this.cozinhaRepository = cozinhaRepository;
        this.cozinhaService = cozinhaService;
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
        var cozinha = cozinhaRepository.findById(id);
        return cozinha.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping("/por-nome")
    public List<Cozinha> findByName(@RequestParam("name") String name) {
        return cozinhaRepository.findByNome(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha save(@RequestBody Cozinha cozinha) {
        return cozinhaService.save(cozinha);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cozinha> update(@PathVariable Long id, @RequestBody Cozinha cozinha) {
        var cozinhaActual = cozinhaRepository.findById(id);
        if (cozinhaActual.isPresent()) {
            BeanUtils.copyProperties(cozinha, cozinhaActual.get(), "id");
            var cozinhaSalva = cozinhaService.save(cozinhaActual.get());
            return ResponseEntity.ok(cozinhaSalva);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cozinha> delete(@PathVariable Long id) {
        try {
            cozinhaService.remove(id);
            return ResponseEntity.noContent().build();
        } catch (EntityInUseException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}







