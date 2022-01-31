package com.victor.colegio.repository;

import com.victor.colegio.entity.Asignatura;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Autor: Víctor Fonseca
 */

@Repository
public interface AsignaturaRepository extends CrudRepository<Asignatura, Long> {
    @Query("select a from Asignatura a where a.profesor.id = ?1")
    List<Asignatura> obtenerAsignaturasPorProfesor(Long id);
}