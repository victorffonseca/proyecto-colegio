package com.victor.colegio.repository;

import com.victor.colegio.entity.Asignatura;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Autor: Víctor Fonseca
 */

@Repository
public interface AsignaturaRepository extends CrudRepository<Asignatura, Long> {
}