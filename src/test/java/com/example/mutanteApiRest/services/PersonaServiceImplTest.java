package com.example.mutanteApiRest.services;

import com.example.mutanteApiRest.entities.Persona;
import com.example.mutanteApiRest.repositories.PersonaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.support.GenericGroovyXmlContextLoader;

import java.util.Arrays;

@SpringBootTest
public class PersonaServiceImplTest {

    @MockBean
    private PersonaRepository personaRepository;

    @Autowired
    private PersonaServiceImpl personaService;

    @Test
    void testStats() throws Exception{
        Persona persona = new Persona();
        persona.setAdn(Arrays.asList("AAAA","ATGC","AGCC","ATCG"));
        persona.setMutante(true);

        Persona persona1 = new Persona();
        persona1.setAdn(Arrays.asList("ACTG","TCGG","AATT", "GGCC"));
        persona1.setMutante(false);
        float cantMutante = 1;
        float cantHumano = 1;

        Mockito.when(personaRepository.obtenerCantidad(true)).thenReturn(cantMutante);
        Mockito.when(personaRepository.obtenerCantidad(false)).thenReturn(cantHumano);

        Assertions.assertEquals(cantMutante,personaService.obtenerCantidad(true));
        Assertions.assertEquals(cantHumano,personaService.obtenerCantidad(false));
    }
}
