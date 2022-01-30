package com.victor.colegio.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "profesor")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Profesor implements Serializable {

    @Id
    private Long id;

    @Column
    private String nombre;

    @OneToMany(mappedBy = "profesor", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("estudiantes")
    private List<Asignatura> asignaturas;
}
