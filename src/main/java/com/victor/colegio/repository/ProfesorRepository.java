package com.victor.colegio.repository;

import com.victor.colegio.entity.Profesor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Autor: Víctor Fonseca
 */

@Repository
public interface ProfesorRepository extends CrudRepository<Profesor, Long> {
}
