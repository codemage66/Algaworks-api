package io.github.manuelernesto.algafoodapi.api.controller;

import io.github.manuelernesto.algafoodapi.domain.model.Estado;
import io.github.manuelernesto.algafoodapi.domain.repository.EstadoRepository;
import io.github.manuelernesto.algafoodapi.domain.services.CadastroEstadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    private final EstadoRepository estadoRepository;
    private final CadastroEstadoService cadastroEstadoService;

    public EstadoController(EstadoRepository estadoRepository, CadastroEstadoService cadastroEstadoService) {
        this.estadoRepository = estadoRepository;
        this.cadastroEstadoService = cadastroEstadoService;
    }

    @GetMapping
    public List<Estado> list() {
        return estadoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Estado> save(@RequestBody Estado estado) {
        estado = cadastroEstadoService.save(estado);
        return ResponseEntity.status(HttpStatus.CREATED).body(estado);
    }
}
