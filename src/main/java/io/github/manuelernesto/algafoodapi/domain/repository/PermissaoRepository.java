package io.github.manuelernesto.algafoodapi.domain.repository;

import io.github.manuelernesto.algafoodapi.domain.model.Permissao;

import java.util.List;

public interface PermissaoRepository {
    List<Permissao> findAll();

    Permissao findByID(Long id);

    Permissao add(Permissao permissao);

    void remove(Permissao permissao);
}
