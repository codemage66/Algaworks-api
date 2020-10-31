package io.github.manuelernesto.algafoodapi.infrastructure.repository;

import io.github.manuelernesto.algafoodapi.domain.model.Cidade;
import io.github.manuelernesto.algafoodapi.domain.repository.CidadeRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CidadeRepositoryImpl implements CidadeRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cidade> findAll() {
        return manager.createQuery("FROM Cidade", Cidade.class)
                .getResultList();
    }

    @Override
    public Cidade findByID(Long id) {
        return manager.find(Cidade.class, id);
    }

    @Override
    @Transactional
    public Cidade add(Cidade cidade) {
        return manager.merge(cidade);
    }

    @Override
    @Transactional
    public void remove(Cidade cidade) {
        cidade = findByID(cidade.getId());
        manager.remove(cidade);
    }
}
