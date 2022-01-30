package com.victor.colegio.service;

import com.victor.colegio.entity.Profesor;

import java.util.List;
import java.util.Optional;

/**
 * Autor: Víctor Fonseca
 */

public interface ProfesorService {
    List<Profesor> obtenerProfesores();
    Optional<Profesor> obtenerProfesorPorId(Long id);
}
