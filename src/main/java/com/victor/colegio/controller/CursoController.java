package com.victor.colegio.controller;

import com.victor.colegio.entity.Curso;
import com.victor.colegio.service.CursoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Autor: Víctor Fonseca
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation("Obtener todos los cursos")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Curso>> obtenerCursos() {
        List<Curso> listaCursos = cursoService.obtenerCursos();
        return new ResponseEntity<>(listaCursos, HttpStatus.OK);
    }
}
