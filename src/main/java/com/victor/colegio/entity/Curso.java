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
@Table(name = "curso")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Curso implements Serializable {

    @Id
    private Long id;

    @Column
    private String grado;

    @Column
    private String salon;

    @ManyToOne
    @JoinColumn(name = "id_colegio")
    @JsonIgnoreProperties("cursos")
    private Colegio colegio;

    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("estudiantes")
    private List<Asignatura> asignaturas;
}
