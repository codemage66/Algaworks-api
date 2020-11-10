package io.github.manuelernesto.algafoodapi.api.controller;

import io.github.manuelernesto.algafoodapi.domain.model.Restaurante;
import io.github.manuelernesto.algafoodapi.domain.repository.RestauranteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    private final RestauranteRepository restauranteRepository;

    public RestauranteController(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
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
