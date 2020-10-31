package io.github.manuelernesto.algafoodapi.infrastructure.repository;

import io.github.manuelernesto.algafoodapi.domain.model.FormaPagamento;
import io.github.manuelernesto.algafoodapi.domain.model.Restaurante;
import io.github.manuelernesto.algafoodapi.domain.repository.FormaPagamentoRepository;
import io.github.manuelernesto.algafoodapi.domain.repository.RestauranteRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<FormaPagamento> findAll() {
        return manager.createQuery("FROM FormaPagamento", FormaPagamento.class)
                .getResultList();
    }

    @Override
    public FormaPagamento findByID(Long id) {
        return manager.find(FormaPagamento.class, id);
    }

    @Override
    @Transactional
    public FormaPagamento add(FormaPagamento formaPagamento) {
        return manager.merge(formaPagamento);
    }

    @Override
    @Transactional
    public void remove(FormaPagamento formaPagamento) {
        formaPagamento = findByID(formaPagamento.getId());
        manager.remove(formaPagamento);
    }
}
