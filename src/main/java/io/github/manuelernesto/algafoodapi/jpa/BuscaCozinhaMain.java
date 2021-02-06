package io.github.manuelernesto.algafoodapi.jpa;

import io.github.manuelernesto.algafoodapi.AlgafoodApiApplication;
import io.github.manuelernesto.algafoodapi.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class BuscaCozinhaMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new SpringApplicationBuilder(AlgafoodApiApplication.class)
                        .web(WebApplicationType.NONE)
                        .run(args);

        var repository = context.getBean(CozinhaRepository.class);

        //var cozinha = repository.findByID(2L);

        // System.out.println(cozinha.getNome());


    }
}










