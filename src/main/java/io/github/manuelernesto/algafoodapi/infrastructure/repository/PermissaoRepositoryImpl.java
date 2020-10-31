package io.github.manuelernesto.algafoodapi.infrastructure.repository;

import io.github.manuelernesto.algafoodapi.domain.model.Permissao;
import io.github.manuelernesto.algafoodapi.domain.repository.PermissaoRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class PermissaoRepositoryImpl implements PermissaoRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Permissao> findAll() {
        return manager.createQuery("FROM Permissao", Permissao.class)
                .getResultList();
    }

    @Override
    public Permissao findByID(Long id) {
        return manager.find(Permissao.class, id);
    }

    @Override
    @Transactional
    public Permissao add(Permissao permissao) {
        return manager.merge(permissao);
    }

    @Override
    @Transactional
    public void remove(Permissao permissao) {
        permissao = findByID(permissao.getId());
        manager.remove(permissao);
    }
}
