package com.example.mutanteApiRest.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ADN")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Audited
public class Persona extends Base {

    @Column(name = "nombre")
    private String nombre;

    @ElementCollection
    private List<String> adn;

    @Column(name = "isMutante")
    private boolean mutante;
}
