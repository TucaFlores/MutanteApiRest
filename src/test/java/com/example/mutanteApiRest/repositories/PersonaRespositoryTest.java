package com.example.mutanteApiRest.repositories;

import com.example.mutanteApiRest.entities.Persona;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import java.util.Arrays;


@SpringBootTest
class PersonaRespositoryTest {

    @Autowired
    private PersonaRepository personaRepository;

    @Test
    void testStats(){
        Persona persona = new Persona();
        persona.setAdn(Arrays.asList("AAAAGCT","ATGCCGT","AGCCTGC","ATCGCGG","AAAAGCT","AAAAGCT","AAAAGCT"));
        persona.setMutante(true);

        float cantMutante = 1;

        personaRepository.save(persona);


        Assertions.assertEquals(cantMutante,personaRepository.obtenerCantidad(true));

    }

}
