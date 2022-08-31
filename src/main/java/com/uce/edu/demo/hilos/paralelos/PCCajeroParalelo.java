package com.uce.edu.demo.hilos.paralelos;

import java.util.concurrent.TimeUnit;

public class PCCajeroParalelo extends Thread{
	
	private CajeroParalelo cajero;
	
	//Run dispara el metodo a paralelizar
	public PCCajeroParalelo(CajeroParalelo cajero) {
		this.cajero=cajero;
	}
	
	
	
	@Override
	public void run() {
		this.procesar(cajero);
	}
	
	public void procesar(CajeroParalelo cajero) {
		long tiempoInicial=System.currentTimeMillis();

		System.out.println("Nombre Hilo Procesar: "+Thread.currentThread().getName());
		System.out.println("Procesando Cajero: "+cajero.getNombre());
		
		for(String cliente: cajero.getClientes()) {
			this.atenderCliente(cliente);
		}
		long tiempoFinal=System.currentTimeMillis();
		
		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		System.out.println("Terminó: "+cajero.getNombre()+ " en " +tiempoTranscurrido);
	}
	
	private void atenderCliente(String cliente) {
		System.out.println("Atendiendo a : "+cliente);
		//Demorar el metodo 10 seg
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
