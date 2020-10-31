package io.github.manuelernesto.algafoodapi.domain.repository;

import io.github.manuelernesto.algafoodapi.domain.model.FormaPagamento;
import io.github.manuelernesto.algafoodapi.domain.model.Restaurante;

import java.util.List;

public interface FormaPagamentoRepository {
    List<FormaPagamento> findAll();

    FormaPagamento findByID(Long id);

    FormaPagamento add(FormaPagamento formaPagamento);

    void remove(FormaPagamento formaPagamento);
}
