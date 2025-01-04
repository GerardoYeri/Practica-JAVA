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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Productos")
public class Producto {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name= "Nombre")
	private String name;
	
	@Column(name = "Stock")
	private int stock;
	
	@Column(name = "Costo sin IVA")
	private double costExcludingTax;
	
	@Column(name = "Costo con IVA")
	private double costIncludingTax;
	
	@Column(name = "Porcentaje de Ganancia")
	private double profitPercentage;
	
	@Column(name = "Precio de venta sin IVA")
	private double salePriceExcludingTax;
	
	@Column(name = "Precio de venta con IVA")
	private double salePriceIncludingTax;
	
	@Column(name = "Fecha de creacion")
	private LocalDateTime createDateTime;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
				name = "producto_cliente",
				joinColumns = @JoinColumn(name = "producto_id"),
				inverseJoinColumns = @JoinColumn(name = "cliente_id")
				)
	@JsonIgnore
	private List<Cliente> clientes = new ArrayList<>();

	public Producto() {
		super();
		this.createDateTime = LocalDateTime.now();
	}

	public Producto(Long id, String name, int stock, double costExcludingTax, double costIncludingTax, double profitPercentage,
			double salePriceExcludingTax, double salePriceIncludingTax, LocalDateTime createDateTime,
			List<Cliente> clientes) {
		super();
		this.id = id;
		this.name = name;
		this.stock = stock;
		this.costExcludingTax = costExcludingTax;
		this.costIncludingTax = costIncludingTax;
		this.profitPercentage = profitPercentage;
		this.salePriceExcludingTax = salePriceExcludingTax;
		this.salePriceIncludingTax = salePriceIncludingTax;
		this.createDateTime = LocalDateTime.now();
		this.clientes = clientes;
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getCostExcludingTax() {
		return costExcludingTax;
	}

	public void setCostExcludingTax(double costExcludingTax) {
		this.costExcludingTax = costExcludingTax;
	}

	public double getCostIncludingTax() {
		return costIncludingTax;
	}

	public void setCostIncludingTax(double costIncludingTax) {
		this.costIncludingTax = costIncludingTax;
	}

	public double getProfitPercentage() {
		return profitPercentage;
	}

	public void setProfitPercentage(double profit) {
		this.profitPercentage = profit;
	}

	public double getSalePriceExcludingTax() {
		return salePriceExcludingTax;
	}

	public void setSalePriceExcludingTax(double salePriceExcludingTax) {
		this.salePriceExcludingTax = salePriceExcludingTax;
	}

	public double getSalePriceIncludingTax() {
		return salePriceIncludingTax;
	}

	public void setSalePriceIncludingTax(double salePriceIncludingTax) {
		this.salePriceIncludingTax = salePriceIncludingTax;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
	
	
	
	
	
}
