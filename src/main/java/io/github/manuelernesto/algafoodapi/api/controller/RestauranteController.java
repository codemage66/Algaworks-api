package io.github.manuelernesto.algafoodapi.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.manuelernesto.algafoodapi.domain.exception.EntityNotFoundException;
import io.github.manuelernesto.algafoodapi.domain.model.Restaurante;
import io.github.manuelernesto.algafoodapi.domain.repository.RestauranteRepository;
import io.github.manuelernesto.algafoodapi.domain.services.CadastroRestauranteService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

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

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Restaurante restaurante) {
        var restauranteAtual = restauranteRepository.findByID(id);
        if (restauranteAtual != null)
            try {
                BeanUtils.copyProperties(restaurante, restauranteAtual, "id");
                restauranteAtual = cadastroRestauranteService.save(restaurante);
                return ResponseEntity.ok(restauranteAtual);
            } catch (EntityNotFoundException e) {
                return ResponseEntity.badRequest()
                        .body(e.getMessage());
            }
        return ResponseEntity.notFound().build();
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

    @PatchMapping("/{id}")
    public ResponseEntity<?> updatePartial(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        var restauranteAtual = restauranteRepository.findByID(id);

        if (restauranteAtual == null) return ResponseEntity.notFound().build();

        merge(fields, restauranteAtual);

        return update(id, restauranteAtual);

    }

    private void merge(Map<String, Object> fields, Restaurante restauranteDestino) {
        ObjectMapper objectMapper = new ObjectMapper();
        Restaurante restauranteOrigem = objectMapper.convertValue(fields, Restaurante.class);

        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Restaurante.class, key);
            assert field != null;
            field.setAccessible(true);
            Object novoValor = ReflectionUtils.getField(field, restauranteOrigem);
            ReflectionUtils.setField(field, restauranteDestino, novoValor);
        });
    }
}
