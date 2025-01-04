package com.practica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
