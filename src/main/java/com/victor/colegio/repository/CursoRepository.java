package com.victor.colegio.repository;

import com.victor.colegio.entity.Curso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Autor: Víctor Fonseca
 */

@Repository
public interface CursoRepository extends CrudRepository<Curso, Long> {
}
