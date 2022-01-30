package com.victor.colegio.controller;

import com.victor.colegio.entity.Estudiante;
import com.victor.colegio.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:4200")
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Estudiante>> obtenerEstudiantes() {
        List<Estudiante> listaEstudiantes = estudianteService.obtenerEstudiantes();
        return new ResponseEntity<>(listaEstudiantes, HttpStatus.OK);
    }
}
