package io.github.manuelernesto.algafoodapi.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;


@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(name = "taxa_frete")
    private BigDecimal taxaFrete;
}
