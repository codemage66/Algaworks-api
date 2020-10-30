package io.github.manuelernesto.algafoodapi.jpa;

import io.github.manuelernesto.algafoodapi.AlgafoodApiApplication;
import io.github.manuelernesto.algafoodapi.domain.repository.CozinhaRepository;
import io.github.manuelernesto.algafoodapi.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class ConsultaRestauranteMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new SpringApplicationBuilder(AlgafoodApiApplication.class)
                        .web(WebApplicationType.NONE)
                        .run(args);

        var repository = context.getBean(RestauranteRepository.class);

        var restaurantes = repository.findAll();


        for (var restaurante : restaurantes) {
            System.out.printf("%s - %s - %s \n",
                    restaurante.getNome(),
                    restaurante.getTaxaFrete(),
                    restaurante.getCozinha().getNome());
        }

    }
}










