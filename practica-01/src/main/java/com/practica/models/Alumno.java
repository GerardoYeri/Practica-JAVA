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
@Table(name = "Alumnos")
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Nombre", nullable = false)
	private String name;
	
	@Column(name = "Apellido", nullable = false)
	private String surname;
	
	@Column(name = "DNI", nullable = false, unique = true)
	private int dni;
	
	@Column(name = "Legajo", unique = true, nullable = false)
	private String legajo;
	
	@Column(name = "Fecha de inicio")
	private LocalDateTime creaDateTime;
	
	@ManyToMany(mappedBy = "alumnos", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Curso> cursos = new ArrayList<>();

	
	
	public Alumno() {
		super();
		this.creaDateTime = LocalDateTime.now();
	}
	
	

	public Alumno(Long id, String name, String surname, int dni, String legajo, LocalDateTime creaDateTime,
			List<Curso> cursos) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.dni = dni;
		this.legajo = legajo;
		this.creaDateTime = LocalDateTime.now();
		this.cursos = cursos;
	}

	


	public Alumno(String name, String surname, int dni, String legajo) {
		super();
		this.name = name;
		this.surname = surname;
		this.dni = dni;
		this.legajo = legajo;
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

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public LocalDateTime getCreaDateTime() {
		return creaDateTime;
	}

	public void setCreaDateTime(LocalDateTime creaDateTime) {
		this.creaDateTime = creaDateTime;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}



	@Override
	public String toString() {
		return "Alumno [id=" + id + ", name=" + name + ", surname=" + surname + ", dni=" + dni + ", legajo=" + legajo
				+ ", creaDateTime=" + creaDateTime + ", cursos=" + cursos + "]";
	} 
	
	
	
}
