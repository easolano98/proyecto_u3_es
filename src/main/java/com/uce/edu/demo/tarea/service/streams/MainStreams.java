package com.uce.edu.demo.tarea.service.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MainStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Stream Supplier
		Stream<List<Integer>>test=Stream.generate(()->Arrays.asList(1,2,3)).limit(8);
		test.forEach(cadena->System.out.print("Stream Supplier "+cadena));
		
		//Stream Consumer
		List<String>alimentos=Arrays.asList("Peras","Fideos","Papas","Arroz");
		alimentos.forEach(listaAlimentos->System.out.println("Stream Consumer "+"["+listaAlimentos+"]"));
		
		//Stream Predicate
		Stream<String>lista=alimentos.stream().filter(palabra->palabra.equals("Peras"));
		lista.forEach(palabra->System.out.println("Stream Predicate " + palabra));
		
		//Stream Function
		List<Integer>listaNumero= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		Stream<Double>cambio=listaNumero.stream().map(numero-> numero.doubleValue());
		cambio.forEach(numero->System.out.println("Stream Function "+"["+numero+"]"));
	
	}

}
