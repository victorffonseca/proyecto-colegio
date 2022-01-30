package com.victor.colegio.controller;

import com.victor.colegio.entity.Asignatura;
import com.victor.colegio.service.AsignaturaService;
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
@RequestMapping("/asignaturas")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation("Obtener todas las asignaturas")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Asignatura>> obtenerAsignaturas() {
        List<Asignatura> listaAsignaturas = asignaturaService.obtenerAsignaturas();
        return new ResponseEntity<>(listaAsignaturas, HttpStatus.OK);
    }

    @RequestMapping(value = "/profesor/{id}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation("Obtener todas las asignaturas por profesor")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Asignatura>> obtenerAsignaturasPorProfesor(@ApiParam(value = "Id del profesor", required = true, example = "1") @PathVariable("id") long id) {
        List<Asignatura> listaAsignaturas = asignaturaService.obtenerAsignaturasPorProfesor(id);
        return new ResponseEntity<>(listaAsignaturas, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation("Obtener una asignatura por id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Asignatura no encontrada")
    })
    public ResponseEntity<Asignatura> obtenerAsignaturaPorId(@ApiParam(value = "Id de la asignatura", required = true, example = "1") @PathVariable("id") long id) {
        return asignaturaService.obtenerAsignaturaPorId(id)
                .map(asignatura -> new ResponseEntity<>(asignatura, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}