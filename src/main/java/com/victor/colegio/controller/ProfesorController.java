package com.victor.colegio.controller;

import com.victor.colegio.entity.Profesor;
import com.victor.colegio.service.ProfesorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Autor: Víctor Fonseca
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation("Obtener todos los profesores")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Profesor>> obtenerProfesores() {
        List<Profesor> listaProfesores = profesorService.obtenerProfesores();
        return new ResponseEntity<>(listaProfesores, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation("Obtener un profesor por id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Profesor no encontrado")
    })
    public ResponseEntity<Profesor> obtenerProfesorPorId(@ApiParam(value = "Id del profesor", required = true, example = "1") @PathVariable("id") long id) {
        return profesorService.obtenerProfesorPorId(id)
                .map(profesor -> new ResponseEntity<>(profesor, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
