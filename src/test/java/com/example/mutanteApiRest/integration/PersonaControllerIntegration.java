package com.example.mutanteApiRest.integration;

import com.example.mutanteApiRest.MutanteApiApplication;
import com.example.mutanteApiRest.entities.Persona;
import com.example.mutanteApiRest.repositories.PersonaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
/*
@SpringBootTest(classes = MutanteApiApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-testing.properties"
)
public class PersonaControllerIntegration {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PersonaRepository personaRepository;

    @Test
    void testSearch() throws Exception{
        Persona persona = new Persona();
        persona.setNombre("Sebastian");
        persona.setAdn(Arrays.asList("ATGC", "AAAA", "AGGC", "ATGG"));

        personaRepository.save(persona);

    }
}
*/