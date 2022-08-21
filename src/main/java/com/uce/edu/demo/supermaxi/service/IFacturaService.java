package com.uce.edu.demo.supermaxi.service;

import java.util.List;

import com.uce.edu.demo.supermaxi.repository.modelo.Factura;

public interface IFacturaService {
	
	public Factura generar (String cedula, String numeroFactura, List<String>codigos);
	
	public void generarFachada(String cedula, String numeroFactura, List<String>codigos);

}
