package com.example.mutanteApiRest.services;

import com.example.mutanteApiRest.entities.Persona;
import com.example.mutanteApiRest.repositories.PersonaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;

@SpringBootTest
public class PersonaServiceImplTest {

    @MockBean
    private PersonaRepository personaRepository;

    @Autowired
    private PersonaServiceImpl personaService;

    @Test
    void testCantMutante() throws Exception{
        Persona persona = new Persona();
        persona.setAdn(Arrays.asList("AAAA","ATGC","AGCC","ATCG"));

        float cantMutante = 1;

        Mockito.when(personaRepository.cantMutantes()).thenReturn(cantMutante);

        Assertions.assertEquals(cantMutante,personaService.cantMutantes());
    }
    @Test
    void testCantHumano() throws Exception{
        Persona persona = new Persona();
        persona.setAdn(Arrays.asList("AGCT","CTGC","AGCC","ATCG"));

        float cantHumano = 1;

        Mockito.when(personaRepository.cantMutantes()).thenReturn(cantHumano);

        Assertions.assertEquals(cantHumano,personaService.cantMutantes());
    }

}
