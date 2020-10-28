package io.github.manuelernesto.algafoodapi.jpa;

import io.github.manuelernesto.algafoodapi.AlgafoodApiApplication;
import io.github.manuelernesto.algafoodapi.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class IncluirCozinhaMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new SpringApplicationBuilder(AlgafoodApiApplication.class)
                        .web(WebApplicationType.NONE)
                        .run(args);

        var cadastroCozinha = context.getBean(CadastroCozinha.class);

        var cozinha1 = new Cozinha();
        var cozinha2 = new Cozinha();
        cozinha1.setNome("Italiana");
        cozinha2.setNome("Japonesa");


        cozinha1 = cadastroCozinha.adicionar(cozinha1);
        cozinha2 = cadastroCozinha.adicionar(cozinha2);

        System.out.println("Cozinha Salva1: " + cozinha1.getNome());
        System.out.println("Cozinha Salva2: " + cozinha2.getNome());

    }
}










