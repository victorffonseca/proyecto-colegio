package com.victor.colegio.service.serviceImpl;

import com.victor.colegio.entity.Colegio;
import com.victor.colegio.repository.ColegioRepository;
import com.victor.colegio.service.ColegioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColegioServiceImpl implements ColegioService {

    @Autowired
    private ColegioRepository colegioRepository;

    @Override
    public List<Colegio> obtenerColegios() {
        return (List<Colegio>) colegioRepository.findAll();
    }
}