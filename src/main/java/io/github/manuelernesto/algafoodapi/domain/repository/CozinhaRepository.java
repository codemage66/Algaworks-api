package io.github.manuelernesto.algafoodapi.domain.repository;

import io.github.manuelernesto.algafoodapi.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {
    List<Cozinha> findByNomeContaining(String name);
}
