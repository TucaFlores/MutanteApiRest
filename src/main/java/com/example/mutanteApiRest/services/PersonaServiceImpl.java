package com.example.mutanteApiRest.services;

import com.example.mutanteApiRest.algoritmo.Matriz;
import com.example.mutanteApiRest.entities.Persona;
import com.example.mutanteApiRest.repositories.BaseRepository;
import com.example.mutanteApiRest.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository){
        super(baseRepository);
    }

    public float obtenerCantidad(boolean v) throws Exception{
        try {
            float cantidad = this.personaRepository.obtenerCantidad(v);
            return cantidad;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
