package com.victor.colegio.controller;

import com.victor.colegio.entity.Profesor;
import com.victor.colegio.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Profesor>> obtenerProfesores() {
        List<Profesor> listaProfesores = profesorService.obtenerProfesores();
        return new ResponseEntity<>(listaProfesores, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Profesor> obtenerProfesorPorId(@PathVariable("id") long id) {
        return profesorService.obtenerProfesorPorId(id)
                .map(profesor -> new ResponseEntity<>(profesor, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
