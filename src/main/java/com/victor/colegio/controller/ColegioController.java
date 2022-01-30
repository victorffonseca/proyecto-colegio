package com.victor.colegio.controller;

import com.victor.colegio.entity.Colegio;
import com.victor.colegio.service.ColegioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/colegios")
public class ColegioController {

    @Autowired
    private ColegioService colegioService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Colegio>> obtenerColegios() {
        List<Colegio> listaColegios = colegioService.obtenerColegios();
        return new ResponseEntity<>(listaColegios, HttpStatus.OK);
    }
}
