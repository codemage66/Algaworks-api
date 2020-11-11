package io.github.manuelernesto.algafoodapi.domain.services;

import io.github.manuelernesto.algafoodapi.domain.model.Estado;
import io.github.manuelernesto.algafoodapi.domain.repository.EstadoRepository;
import org.springframework.stereotype.Service;

@Service
public class CadastroEstadoService {
    public CadastroEstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    private final EstadoRepository estadoRepository;

    public Estado save(Estado estado) {
        return estadoRepository.add(estado);
    }

}
