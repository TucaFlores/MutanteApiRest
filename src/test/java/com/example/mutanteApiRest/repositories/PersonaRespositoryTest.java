package com.example.mutanteApiRest.repositories;

import com.example.mutanteApiRest.entities.Persona;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import java.util.Arrays;


@DataJpaTest
class PersonaRespositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private PersonaRepository personaRepository;

    @Test
    void testSearchCantMutante(){
        Persona persona = new Persona();
        persona.setNombre("Sebastian");
        persona.setAdn(Arrays.asList("AAAA","ATGC","AGCC","ATCG"));
        persona.setMutante(true);

        float cantMutante = 1;

        entityManager.persist(persona);
        entityManager.flush();

        Assertions.assertEquals(cantMutante,personaRepository.cantMutantes());

    }
    @Test
    void testSearchCantHumano(){
        Persona persona = new Persona();
        persona.setNombre("Sebastian");
        persona.setAdn(Arrays.asList("AGCT","CTGC","AGCC","ATCG"));
        persona.setMutante(false);

        float cantHumano = 1;

        entityManager.persist(persona);
        entityManager.flush();

        Assertions.assertEquals(cantHumano,personaRepository.cantHumanos());

    }
}
