package com.uce.edu.demo.hilos.paralelos;

import java.util.Arrays;

public class MainParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long tiempoInicial=System.currentTimeMillis();
		
		System.out.println("Nombre Hilo: "+Thread.currentThread().getName());
		CajeroParalelo cajero1=new CajeroParalelo("Edison", Arrays.asList("Pepito"));
		CajeroParalelo cajero2=new CajeroParalelo("Erick", Arrays.asList("Pepito2"));
		CajeroParalelo cajero3=new CajeroParalelo("Emily", Arrays.asList("Pepito3"));
		CajeroParalelo cajero4=new CajeroParalelo("Rose", Arrays.asList("Juan"));
		CajeroParalelo cajero5=new CajeroParalelo("Wilson", Arrays.asList("Juan2"));
		CajeroParalelo cajero6=new CajeroParalelo("Eduardo", Arrays.asList("Juan3"));
		
		
		
		
		PCCajeroParalelo gestorAtencion=new PCCajeroParalelo(cajero1);
		gestorAtencion.start();
		PCCajeroParalelo gestorAtencion2=new PCCajeroParalelo(cajero2);
		gestorAtencion2.start();
		PCCajeroParalelo gestorAtencion3=new PCCajeroParalelo(cajero3);
		gestorAtencion3.start();
		PCCajeroParalelo gestorAtencion4=new PCCajeroParalelo(cajero4);
		gestorAtencion4.start();
		PCCajeroParalelo gestorAtencion5=new PCCajeroParalelo(cajero5);
		gestorAtencion5.start();
		PCCajeroParalelo gestorAtencion6=new PCCajeroParalelo(cajero6);
		gestorAtencion6.start();
		
		long tiempoFinal=System.currentTimeMillis();
		
		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		
		System.out.println(tiempoTranscurrido+" seg");
	}

}
