package com.uce.edu.demo.tarea.service.hilos;

import java.util.List;

public class CyberCafe {
	
	private String numeroMaquina;
	private List<String>clientesDiarios;
	private Integer tiempo;

	public CyberCafe(String numeroMaquina, List<String> clientesDiarios, Integer tiempo) {
		super();
		this.numeroMaquina = numeroMaquina;
		this.clientesDiarios = clientesDiarios;
		this.tiempo= tiempo;
	}

	public String getNumeroMaquina() {
		return numeroMaquina;
	}

	public void setNumeroMaquina(String numeroMaquina) {
		this.numeroMaquina = numeroMaquina;
	}

	public List<String> getClientesDiarios() {
		return clientesDiarios;
	}

	public void setClientesDiarios(List<String> clientesDiarios) {
		this.clientesDiarios = clientesDiarios;
	}

	public Integer getTiempo() {
		return tiempo;
	}

	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}
	
	
	
	
}
