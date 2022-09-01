package com.uce.edu.demo.tarea.service.hilos;

import java.util.concurrent.TimeUnit;

public class ComputadoraCyber extends Thread {

	private CyberCafe cyber;

	public ComputadoraCyber(CyberCafe cyber) {
		super();
		this.cyber = cyber;
	}

	@Override
	public void run() {
		this.usoPC(cyber);
	}

	public void usoPC(CyberCafe cyber) {
		long tiempoInicial = System.currentTimeMillis();

		System.out.println("Nombre Hilo Procesar: " + Thread.currentThread().getName());
		System.out.println("Maquina alquilada: " + cyber.getNumeroMaquina());

		for (String cliente : cyber.getClientesDiarios()) {
			this.alquilarPC(cliente, cyber.getTiempo());
		}

		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		System.out.println("Terminó: " + cyber.getNumeroMaquina() + " su tiempo en uso fue " + tiempoTranscurrido);

	}

	private void alquilarPC(String cliente, int tiempo) {
		System.out.println("Usando PC el cliente " + cliente);
		try {
			TimeUnit.SECONDS.sleep(tiempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
