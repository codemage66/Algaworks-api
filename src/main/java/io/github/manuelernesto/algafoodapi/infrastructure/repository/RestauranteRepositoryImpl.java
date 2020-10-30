package io.github.manuelernesto.algafoodapi.infrastructure.repository;

import io.github.manuelernesto.algafoodapi.domain.model.Cozinha;
import io.github.manuelernesto.algafoodapi.domain.model.Restaurante;
import io.github.manuelernesto.algafoodapi.domain.repository.CozinhaRepository;
import io.github.manuelernesto.algafoodapi.domain.repository.RestauranteRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurante> findAll() {
        return manager.createQuery("FROM Restaurante", Restaurante.class)
                .getResultList();
    }

    @Override
    public Restaurante findByID(Long id) {
        return manager.find(Restaurante.class, id);
    }

    @Override
    @Transactional
    public Restaurante add(Restaurante restaurante) {
        return manager.merge(restaurante);
    }

    @Override
    @Transactional
    public void remove(Restaurante restaurante) {
        restaurante = findByID(restaurante.getId());
        manager.remove(restaurante);
    }
}
