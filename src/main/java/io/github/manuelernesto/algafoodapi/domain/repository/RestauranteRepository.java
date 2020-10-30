package io.github.manuelernesto.algafoodapi.domain.repository;

import io.github.manuelernesto.algafoodapi.domain.model.Cozinha;
import io.github.manuelernesto.algafoodapi.domain.model.Restaurante;

import java.util.List;

public interface RestauranteRepository {
    List<Restaurante> findAll();

    Restaurante findByID(Long id);

    Restaurante add(Restaurante restaurante);

    void remove(Restaurante restaurante);
}
