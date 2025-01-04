package com.practica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
