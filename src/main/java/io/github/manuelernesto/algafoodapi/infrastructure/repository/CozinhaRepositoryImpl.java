package io.github.manuelernesto.algafoodapi.infrastructure.repository;

import io.github.manuelernesto.algafoodapi.domain.model.Cozinha;
import io.github.manuelernesto.algafoodapi.domain.repository.CozinhaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cozinha> findAll() {
        return manager.createQuery("FROM Cozinha", Cozinha.class)
                .getResultList();
    }

    @Override
    public Cozinha findByID(Long id) {
        return manager.find(Cozinha.class, id);
    }

    @Override
    @Transactional
    public Cozinha add(Cozinha cozinha) {
        return manager.merge(cozinha);
    }

    @Override
    @Transactional
    public void remove(Cozinha cozinha) {
        cozinha = findByID(cozinha.getId());
        manager.remove(cozinha);
    }
}
