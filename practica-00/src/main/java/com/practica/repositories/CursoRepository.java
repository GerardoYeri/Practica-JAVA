package com.practica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
