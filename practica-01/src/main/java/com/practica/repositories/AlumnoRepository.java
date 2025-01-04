package com.practica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.models.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

}
