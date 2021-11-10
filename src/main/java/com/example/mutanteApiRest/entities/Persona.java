package com.example.mutanteApiRest.entities;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Persona")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Audited
public class Persona extends Base {

    @ElementCollection
    private List<String> adn;

    @Column(name = "isMutante")
    private boolean mutante;
}
