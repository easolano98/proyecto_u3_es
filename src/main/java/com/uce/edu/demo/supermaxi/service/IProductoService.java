package com.uce.edu.demo.supermaxi.service;

import com.uce.edu.demo.supermaxi.repository.modelo.Producto;

public interface IProductoService {
	
	public void insertar (Producto producto);
	
	public void actualizar(Producto producto);
	
	public Producto buscar (String numero);
	
	
}
