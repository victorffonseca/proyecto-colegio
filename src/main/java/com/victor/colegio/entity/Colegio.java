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
@Table(name = "colegio")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Colegio implements Serializable {

    @Id
    private Long id;

    @Column
    private String nombre;

    @JsonIgnoreProperties("asignaturas")
    @OneToMany(mappedBy = "colegio", fetch = FetchType.LAZY)
    private List<Curso> cursos;
}