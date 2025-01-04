package com.practica.services;

import org.springframework.stereotype.Service;

import com.practica.models.Producto;

@Service
public class ProductoService {
	
	public static final double IVA = 0.21;
	
	public Producto calculatePrice(Producto producto) {
		
		double costExcludingTax = calculateCostExcludingTax(producto.getCostIncludingTax());
		double salePriceExcludingTax = calculateSalePriceExcludingTax(producto.getProfitPercentage(), costExcludingTax);
		double salePriceIncludingTax = calculateSalePriceIncludingTax(salePriceExcludingTax);
		
		producto.setCostExcludingTax(costExcludingTax);
		producto.setSalePriceExcludingTax(salePriceExcludingTax);
		producto.setSalePriceIncludingTax(salePriceIncludingTax);
 	return producto;
 	
	}
	
	private double calculateCostExcludingTax(double costIncludingTax) {
		return costIncludingTax / (1 + IVA);
	}
	
	
	private double calculateSalePriceExcludingTax(double profitPercentage, double costExcludingTax) {
		double profit = (profitPercentage/100) * costExcludingTax;
		return profit + costExcludingTax;
	}
	
	private double calculateSalePriceIncludingTax(double salePriceExcludingTax) {
		return salePriceExcludingTax * (1+IVA);
	}
}
