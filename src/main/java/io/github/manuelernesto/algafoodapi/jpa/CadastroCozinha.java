package io.github.manuelernesto.algafoodapi.jpa;

import io.github.manuelernesto.algafoodapi.domain.model.Cozinha;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CadastroCozinha {

    @PersistenceContext
    private EntityManager manager;

    public List<Cozinha> getAll() {
        return manager.createQuery("FROM Cozinha", Cozinha.class)
                .getResultList();
    }

    public Cozinha findByID(Long id) {
        return manager.find(Cozinha.class, id);
    }

    @Transactional
    public Cozinha save(Cozinha cozinha) {
        return manager.merge(cozinha);
    }

    @Transactional
    public void delete(Cozinha cozinha) {
        cozinha = findByID(cozinha.getId());
        manager.remove(cozinha);
    }

}










