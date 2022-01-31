package com.victor.colegio.service;

import com.victor.colegio.entity.Asignatura;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Autor: Víctor Fonseca
 */

public interface AsignaturaService {
    List<Asignatura> obtenerAsignaturas();
    Optional<Asignatura> obtenerAsignaturaPorId(Long id);
    List<Asignatura> obtenerAsignaturasPorProfesor(Long id);
}
