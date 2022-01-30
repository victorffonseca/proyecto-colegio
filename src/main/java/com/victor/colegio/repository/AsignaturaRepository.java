package com.victor.colegio.repository;

import com.victor.colegio.entity.Asignatura;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaRepository extends CrudRepository<Asignatura, Long> {
}