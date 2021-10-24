package com.example.mutanteApiRest.integration;

import com.example.mutanteApiRest.MutanteApiApplication;
import com.example.mutanteApiRest.entities.Persona;
import com.example.mutanteApiRest.repositories.PersonaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;

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
    void testStats() throws Exception{
        Persona persona = new Persona();
        persona.setNombre("Sebastian");
        persona.setAdn(Arrays.asList("ATGC", "AAAA", "AGGC", "ATGG"));

        personaRepository.save(persona);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/personas/stats")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.count_mutant_dna",is("1.0")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.count_human_dna",is("1.0")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.ratio", is("0.5")));

    }
}
