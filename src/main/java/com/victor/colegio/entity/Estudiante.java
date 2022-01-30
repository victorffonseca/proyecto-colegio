package com.victor.colegio.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Autor: Víctor Fonseca
 */

@Entity
@Table(name = "estudiante")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Estudiante implements Serializable {

    @Id
    private Long id;

    @Column
    private String nombre;

    @ManyToMany
    @JoinTable(
            name = "estudiante_asignatura",
            joinColumns = @JoinColumn(name = "id_estudiante"),
            inverseJoinColumns = @JoinColumn(name = "id_asignatura")
    )
    @JsonIgnoreProperties("estudiantes")
    private List<Asignatura> asignaturas;
}
