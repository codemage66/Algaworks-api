package io.github.manuelernesto.algafoodapi.domain.repository;

import io.github.manuelernesto.algafoodapi.domain.model.Cozinha;

import java.util.List;

public interface CozinhaRepository {
    List<Cozinha> findAll();

    Cozinha findByID(Long id);

    Cozinha save(Cozinha cozinha);

    void remove(Cozinha cozinha);
}
