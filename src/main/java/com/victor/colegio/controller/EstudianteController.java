package com.victor.colegio.controller;

import com.victor.colegio.entity.Estudiante;
import com.victor.colegio.service.EstudianteService;
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
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation("Obtener todos los estudiantes")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Estudiante>> obtenerEstudiantes() {
        List<Estudiante> listaEstudiantes = estudianteService.obtenerEstudiantes();
        return new ResponseEntity<>(listaEstudiantes, HttpStatus.OK);
    }
}
