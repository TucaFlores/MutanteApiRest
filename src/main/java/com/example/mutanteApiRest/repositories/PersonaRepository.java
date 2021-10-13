package com.example.mutanteApiRest.repositories;

import com.example.mutanteApiRest.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {

    @Query(value = "SELECT COUNT (p) FROM Persona p WHERE p.mutante = true")
    float cantMutantes();

    @Query(value = "SELECT COUNT (p) FROM Persona p WHERE p.mutante = false")
    float cantHumanos();
}
