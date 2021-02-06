package io.github.manuelernesto.algafoodapi.domain.services;


import io.github.manuelernesto.algafoodapi.domain.exception.EntityInUseException;
import io.github.manuelernesto.algafoodapi.domain.exception.EntityNotFoundException;
import io.github.manuelernesto.algafoodapi.domain.model.Cozinha;
import io.github.manuelernesto.algafoodapi.domain.repository.CozinhaRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroCozinhaService {

    private final CozinhaRepository cozinhaRepository;

    public CadastroCozinhaService(CozinhaRepository cozinhaRepository) {
        this.cozinhaRepository = cozinhaRepository;
    }

    public Cozinha save(Cozinha cozinha) {
        return cozinhaRepository.save(cozinha);
    }

    public void remove(Long id) {
        try {
            cozinhaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException
                    (String.format("Não existe uma cozinha com código %d", id));
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException
                    (String.format("Cozinha de código %d não pode ser removida", id));
        }
    }
}








