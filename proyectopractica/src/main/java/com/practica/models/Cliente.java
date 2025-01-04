package com.practica.models;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Nombre")
	private String name;

	@Column(name = "Apellido")
	private String surname;
	
	@Column(name = "Edad")
	private int age;
	
	@Column(name = "Celular")
	private Long cel;
	
	@Column(name = "Fecha de creacion")
	private LocalDateTime createDateTime;
	
	@ManyToMany(mappedBy = "clientes", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Producto> productos = new ArrayList<>();

	public Cliente() {
		super();
		this.createDateTime = LocalDateTime.now();
	}

	public Cliente(Long id, String name, String surname, int age, Long cel, LocalDateTime createDateTime,
			List<Producto> productos) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.cel = cel;
		this.createDateTime = LocalDateTime.now();
		this.productos = productos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Long getCel() {
		return cel;
	}

	public void setCel(Long cel) {
		this.cel = cel;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	
}
