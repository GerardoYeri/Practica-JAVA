package com.practica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.models.Producto;
import com.practica.repositories.ProductoRepository;
import com.practica.services.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping
	public List<Producto> getAllProductos(){
		return productoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Producto> getProductoById(@PathVariable Long id){
		if(productoRepository.existsById(id)) {
			Producto producto = productoRepository.findById(id).get();
			return ResponseEntity.ok(producto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public Producto createProducto(@RequestBody Producto producto) {
		producto = productoService.calculatePrice(producto);
		return productoRepository.save(producto);
	}
}
