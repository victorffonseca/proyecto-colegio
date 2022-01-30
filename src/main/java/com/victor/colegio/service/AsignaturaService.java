package com.victor.colegio.service;

import com.victor.colegio.entity.Asignatura;
import com.victor.colegio.entity.Profesor;

import java.util.List;
import java.util.Optional;

public interface AsignaturaService {
    List<Asignatura> obtenerAsignaturas();
    List<Asignatura> obtenerAsignaturasPorProfesor(Long id);
    Optional<Asignatura> obtenerAsignaturaPorId(Long id);
}
