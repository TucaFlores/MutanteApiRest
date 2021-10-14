package com.example.mutanteApiRest.controllers;

import com.example.mutanteApiRest.entities.Persona;
import com.example.mutanteApiRest.services.PersonaServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.CoreMatchers.is;
import java.util.Arrays;


@WebMvcTest(PersonaController.class)
public class PersonaControllerTest {

    @MockBean
    private PersonaServiceImpl personaService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void stats() throws Exception{
        Persona persona1 = new Persona();
        persona1.setNombre("Sebastian");
        persona1.setAdn(Arrays.asList("AAAA","ATGC","AGCC","ATCG"));

        Persona persona2 = new Persona();
        persona2.setNombre("Andres");
        persona2.setAdn(Arrays.asList("AGCT","CTGC","AGCC","ATCG"));

        float cantMutante = 1;
        float cantHumano = 1;

        Mockito.when(personaService.cantHumanos()).thenReturn(cantHumano);
        Mockito.when(personaService.cantMutantes()).thenReturn(cantMutante);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/personas/stats")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.count_mutant_dna",is("1.0")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.count_human_dna",is("1.0")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.ratio", is("0.5")));
        
    }
}
