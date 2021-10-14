package com.example.mutanteApiRest.services;

import com.example.mutanteApiRest.entities.Persona;
import com.example.mutanteApiRest.repositories.BaseRepository;
import com.example.mutanteApiRest.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository){
        super(baseRepository);
    }

    public float cantMutantes() throws Exception{
        try {
            float cantidadMutant = personaRepository.cantMutantes();
            return cantidadMutant;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public float cantHumanos() throws Exception{
        try {
            float cantidadHuman = personaRepository.cantHumanos();
            return cantidadHuman;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }



}
