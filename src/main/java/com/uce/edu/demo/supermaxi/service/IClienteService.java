package com.uce.edu.demo.supermaxi.service;

import com.uce.edu.demo.supermaxi.repository.modelo.Cliente;

public interface IClienteService {
	
	public void insertar (Cliente cliente);
	
	public Cliente buscar (String cedula);
}
