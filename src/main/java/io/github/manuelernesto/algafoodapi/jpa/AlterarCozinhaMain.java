package io.github.manuelernesto.algafoodapi.jpa;

import io.github.manuelernesto.algafoodapi.AlgafoodApiApplication;
import io.github.manuelernesto.algafoodapi.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class AlterarCozinhaMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new SpringApplicationBuilder(AlgafoodApiApplication.class)
                        .web(WebApplicationType.NONE)
                        .run(args);

        var cadastroCozinha = context.getBean(CadastroCozinha.class);

        var cozinha = cadastroCozinha.porId(1L);
        cozinha.setNome("Dadox");

        cozinha = cadastroCozinha.adicionar(cozinha);

        var toPrint = String.format("Cozinha: %s - %s", cozinha.getId(), cozinha.getNome());
        System.out.println(toPrint);

    }
}










