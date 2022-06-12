package com.coder.Java;

import com.coder.Java.lambdas.LembdaTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @Test
    void criaObjetoComSucesso() {
        Pessoa p = new Pessoa.PessoaBuilder()
                .nome("anderson")
                .lastName("santana")
                .idade(35)
                .email("anderson.santana@zup.com.br")
                .build();

        assertEquals("anderson.santana@zup.com.br", p.getEmail());
    }
    @Test
    void lancaExceptionSeNomeForNulo() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Pessoa.PessoaBuilder()
                    .lastName("santana")
                    .idade(35)
                    .email("anderson.santana@zup.com.br")
                    .build();
        });
    }
}
