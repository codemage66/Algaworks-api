package io.github.manuelernesto.algafoodapi.domain.repository;

import io.github.manuelernesto.algafoodapi.domain.model.Cidade;
import io.github.manuelernesto.algafoodapi.domain.model.Cozinha;

import java.util.List;

public interface CidadeRepository {
    List<Cidade> findAll();

    Cidade findByID(Long id);

    Cidade add(Cidade cidade);

    void remove(Cidade cidade);
}
