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
@Table(name = "asignatura")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Asignatura implements Serializable {

    @Id
    private Long id;

    @Column
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    @JsonIgnoreProperties("asignaturas")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    @JsonIgnoreProperties("asignaturas")
    private Profesor profesor;

    @ManyToMany(mappedBy = "asignaturas", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("asignaturas")
    private List<Estudiante> estudiantes;
}
