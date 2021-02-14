package io.github.manuelernesto.algafoodapi.api.infrastructure.repository;

import io.github.manuelernesto.algafoodapi.domain.model.Restaurante;
import io.github.manuelernesto.algafoodapi.domain.repository.RestauranteRepositoryQueries;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {

        var jpql = new StringBuilder();
        jpql.append("from Restaurante where 0=0 ");

        var parameters = new HashMap<String, Object>();

        if (StringUtils.hasLength(nome)) {
            jpql.append("and nome like :nome ");
            parameters.put("nome", "%" + nome + "%");
        }
        if (taxaFreteInicial != null) {
            jpql.append("and taxaFrete >= :taxaFreteInicial ");
            parameters.put("taxaFreteInicial", taxaFreteInicial);
        }
        if (taxaFreteFinal != null) {
            jpql.append("and taxaFrete <= :taxaFreteFinal ");
            parameters.put("taxaFreteFinal", taxaFreteFinal);
        }

        TypedQuery<Restaurante> query = manager.createQuery(jpql.toString(), Restaurante.class);
        parameters.forEach((key, value) -> query.setParameter(key, value));

        return query.getResultList();
    }
}
