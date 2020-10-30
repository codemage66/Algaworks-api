package io.github.manuelernesto.algafoodapi.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Mapping The kitchen
 *
 * @author manuelernest0
 */

@Data
@Entity
public class Cozinha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
}
