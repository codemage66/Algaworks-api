package io.github.manuelernesto.algafoodapi.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@Entity
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(name = "taxa_frete")
    private BigDecimal taxaFrete;
}
