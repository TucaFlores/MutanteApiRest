package com.example.mutanteApiRest.services;

import com.example.mutanteApiRest.algoritmo.Matriz;
import com.example.mutanteApiRest.entities.Persona;
import com.example.mutanteApiRest.repositories.BaseRepository;
import com.example.mutanteApiRest.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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

    public Persona save(Persona entity) throws Exception{
        try{
            Matriz matriz = new Matriz();
            Persona persona = new Persona();
            matriz.setAdn(entity.getAdn().toArray(new String[entity.getAdn().size()]));
            if(matriz.controlCarSize(matriz.getAdn())==false){
                throw new Exception();
            }
            persona.setAdn(entity.getAdn());
            persona.setNombre(entity.getNombre());
            persona.setMutante(matriz.isMutant(matriz.getAdn()));

            personaRepository.save(persona);
            return persona;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
