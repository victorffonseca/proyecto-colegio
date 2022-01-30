package com.victor.colegio.service.serviceImpl;

import com.victor.colegio.entity.Estudiante;
import com.victor.colegio.repository.EstudianteRepository;
import com.victor.colegio.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Autor: Víctor Fonseca
 */

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public List<Estudiante> obtenerEstudiantes() {
        return (List<Estudiante>) estudianteRepository.findAll();
    }
}
