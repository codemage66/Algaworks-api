package io.github.manuelernesto.algafoodapi.infrastructure.repository;

import io.github.manuelernesto.algafoodapi.domain.model.Estado;
import io.github.manuelernesto.algafoodapi.domain.repository.EstadoRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class EstadoRepositoryImpl implements EstadoRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Estado> findAll() {
        return manager.createQuery("FROM Estado", Estado.class)
                .getResultList();
    }

    @Override
    public Estado findByID(Long id) {
        return manager.find(Estado.class, id);
    }

    @Override
    @Transactional
    public Estado add(Estado estado) {
        return manager.merge(estado);
    }

    @Override
    @Transactional
    public void remove(Estado estado) {
        estado = findByID(estado.getId());
        manager.remove(estado);
    }
}
