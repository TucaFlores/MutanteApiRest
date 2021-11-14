package com.example.mutanteApiRest.controllers;

import com.example.mutanteApiRest.algoritmo.Matriz;
import com.example.mutanteApiRest.entities.Persona;
import com.example.mutanteApiRest.entities.parse.JsonDna;
import com.example.mutanteApiRest.services.PersonaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;

import java.util.Arrays;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/personas")
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl> {

    private Gson gson =new Gson();

    @PostMapping("/mutant")
    public ResponseEntity<?> saveMutant(@RequestBody Object entry){
        try {
            Matriz mutante = new Matriz(); //Creo la matriz para después ejecutarlo en el algoritmo
            Persona entity = new Persona();
            JsonDna param = gson.fromJson(entry.toString(), JsonDna.class);
            boolean isMutante;
            if(!mutante.getControl().controlCarSize(param.getDna())){
             return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Matriz no cuadrada o Caracteres no acpetados\"}");
            }
            entity.setAdn(Arrays.asList(param.getDna()));
            mutante.setAdn(param.getDna()); //Le asigno la matriz al algoritmo
            isMutante = mutante.isMutant(mutante.getAdn());
            entity.setMutante(isMutante);//Llamo a la función para saber si es mutante o no
            if(isMutante) {
                return ResponseEntity.status(HttpStatus.OK).body(servicio.save(entity));
            }else{
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(servicio.save(entity));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Intente mas tarde\"}");
        }
    }

    @GetMapping("/stats")
    public ResponseEntity<?> estadisticas(){
        try {
            float cantidadMutantes = servicio.cantMutantes();
            float cantidadHumanos = servicio.cantHumanos();
            float promedio = cantidadMutantes /(cantidadMutantes + cantidadHumanos);
            return ResponseEntity.status(HttpStatus.OK).body("{\"count_mutant_dna\": \""+ cantidadMutantes + "\",\"count_human_dna\": \""+ cantidadHumanos +"\",\"ratio\": \""+ promedio +"\"}");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error \": \""+ e.getMessage() +"\"}"));
        }
    }

}
