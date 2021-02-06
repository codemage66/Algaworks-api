package io.github.manuelernesto.algafoodapi.jpa;

import io.github.manuelernesto.algafoodapi.AlgafoodApiApplication;
import io.github.manuelernesto.algafoodapi.domain.model.Cozinha;
import io.github.manuelernesto.algafoodapi.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class DeleteCozinhaMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new SpringApplicationBuilder(AlgafoodApiApplication.class)
                        .web(WebApplicationType.NONE)
                        .run(args);

        var repository = context.getBean(CozinhaRepository.class);

        var cozinha = new Cozinha();
        cozinha.setId(1L);
       // repository.remove(1L);
    }
}










