package com.victor.colegio.controller;

import com.victor.colegio.entity.Asignatura;
import com.victor.colegio.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:4200")
@RequestMapping("/asignaturas")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Asignatura>> obtenerAsignaturas() {
        List<Asignatura> listaAsignaturas = asignaturaService.obtenerAsignaturas();
        return new ResponseEntity<>(listaAsignaturas, HttpStatus.OK);
    }

    @RequestMapping(value = "/profesor/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Asignatura>> obtenerAsignaturasPorProfesor(@PathVariable("id") long id) {
        List<Asignatura> listaAsignaturas = asignaturaService.obtenerAsignaturasPorProfesor(id);
        return new ResponseEntity<>(listaAsignaturas, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Asignatura> obtenerAsignaturasPorId(@PathVariable("id") long id) {
        return asignaturaService.obtenerAsignaturaPorId(id)
                .map(asignatura -> new ResponseEntity<>(asignatura, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}