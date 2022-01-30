package com.victor.colegio.service.serviceImpl;

import com.victor.colegio.entity.Profesor;
import com.victor.colegio.repository.ProfesorRepository;
import com.victor.colegio.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Autor: Víctor Fonseca
 */

@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public List<Profesor> obtenerProfesores() {
        return (List<Profesor>) profesorRepository.findAll();
    }

    @Override
    public Optional<Profesor> obtenerProfesorPorId(Long id) {
        return profesorRepository.findById(id);
    }
}
