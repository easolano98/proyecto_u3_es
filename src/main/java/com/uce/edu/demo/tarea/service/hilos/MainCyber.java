package com.uce.edu.demo.tarea.service.hilos;

import java.util.Arrays;

public class MainCyber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tiempoInicial=System.currentTimeMillis();
		CyberCafe computadora1=new CyberCafe("1", Arrays.asList("Pepito") ,3);
		CyberCafe computadora2=new CyberCafe("2", Arrays.asList("Juanito") ,2);
		CyberCafe computadora3=new CyberCafe("3", Arrays.asList("Marcelo") ,3);
		CyberCafe computadora4=new CyberCafe("4", Arrays.asList("Maria") ,5);
		CyberCafe computadora5=new CyberCafe("5", Arrays.asList("Anita") ,1);

		ComputadoraCyber compuUso1=new ComputadoraCyber(computadora1);
		compuUso1.start();
		ComputadoraCyber compuUso2=new ComputadoraCyber(computadora2);
		compuUso2.start();
		ComputadoraCyber compuUso3=new ComputadoraCyber(computadora3);
		compuUso3.start();
		ComputadoraCyber compuUso4=new ComputadoraCyber(computadora4);
		compuUso4.start();
		ComputadoraCyber compuUso5=new ComputadoraCyber(computadora5);
		compuUso5.start();
		
		long tiempoFinal=System.currentTimeMillis();
		
		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		
		System.out.println(tiempoTranscurrido+" seg");
		
		
	}

}
