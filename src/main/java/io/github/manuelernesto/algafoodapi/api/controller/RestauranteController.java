package io.github.manuelernesto.algafoodapi.api.controller;

import io.github.manuelernesto.algafoodapi.domain.exception.EntityNotFoundException;
import io.github.manuelernesto.algafoodapi.domain.model.Restaurante;
import io.github.manuelernesto.algafoodapi.domain.repository.RestauranteRepository;
import io.github.manuelernesto.algafoodapi.domain.services.CadastroRestauranteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    private final RestauranteRepository restauranteRepository;
    private final CadastroRestauranteService cadastroRestauranteService;

    public RestauranteController(RestauranteRepository restauranteRepository, CadastroRestauranteService cadastroRestauranteService) {
        this.restauranteRepository = restauranteRepository;
        this.cadastroRestauranteService = cadastroRestauranteService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Restaurante restaurante) {
        try {
            restaurante = cadastroRestauranteService.save(restaurante);
            return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }

    @GetMapping
    public List<Restaurante> list() {
        return restauranteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> find(@PathVariable Long id) {
        var restaurante = restauranteRepository.findByID(id);
        if (restaurante != null)
            return ResponseEntity.ok(restaurante);

        return ResponseEntity.notFound().build();
    }
}
