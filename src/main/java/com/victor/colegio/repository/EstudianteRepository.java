package com.victor.colegio.repository;

import com.victor.colegio.entity.Estudiante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Autor: Víctor Fonseca
 */

@Repository
public interface EstudianteRepository extends CrudRepository<Estudiante, Long> {
}
