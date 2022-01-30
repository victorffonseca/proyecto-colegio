package com.victor.colegio.service.serviceImpl;

import com.victor.colegio.entity.Curso;
import com.victor.colegio.repository.CursoRepository;
import com.victor.colegio.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Autor: Víctor Fonseca
 */

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> obtenerCursos() {
        return (List<Curso>) cursoRepository.findAll();
    }
}
