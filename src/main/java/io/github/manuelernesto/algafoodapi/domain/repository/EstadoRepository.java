package io.github.manuelernesto.algafoodapi.domain.repository;

import io.github.manuelernesto.algafoodapi.domain.model.Cozinha;
import io.github.manuelernesto.algafoodapi.domain.model.Estado;

import java.util.List;

public interface EstadoRepository {
    List<Estado> findAll();

    Estado findByID(Long id);

    Estado add(Estado estado);

    void remove(Estado estado);
}
