package com.uce.edu.demo.tarea.service.funcional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

public class MainIntfFuncionales {
	private static final Logger LOGGER = Logger.getLogger(MainIntfFuncionales.class);
	
	public static boolean prueba(Integer numero) {
		
		return numero>=3;

	}
	
	public static void imprimir(String cadena) {
		LOGGER.info("Impresion: "+cadena);
	}
	
	public static void guardar(String elementoAInsertar) {
		//Consumo para insertar
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Suplier
		
		MetodosHighOrderTarea metodosHo= new MetodosHighOrderTarea();
		
		INumeroSupplier<Integer>supplier=new NumeroSupplierImpl();
		LOGGER.info("Suplier Clase: "+supplier.getGenerarNumero());
		
		INumeroSupplier<Integer>supplierLambda=()-> new Random().nextInt(100);
		LOGGER.info("Suplier Clase: "+supplierLambda.getGenerarNumero());
		
		Integer numeroHo= metodosHo.consumirSupplier(()->new Random().nextInt(100)+new Random().nextInt(500));
		LOGGER.info("HO Supplier "+ numeroHo);
		
		//JAVA
		LOGGER.info("JAVA Supplier ");
		Stream<String>test=Stream.generate(()->"Erick").limit(2);
		test.forEach(cadena-> System.out.println(cadena));
		
		
		//Consumer
		
		IPrecioIvaConsumer<BigDecimal>consumer=new PrecioIvaConsumerImpl();
		consumer.acceptIva(new BigDecimal(15));
		
		
		IPrecioIvaConsumer<BigDecimal>consumerLambda= iva->System.out.println(iva);
		consumerLambda.acceptIva(new BigDecimal(1.35));
		
		metodosHo.consumirConsumer(precio->System.out.println("valor iva HO"+ precio), new BigDecimal(3.25));
		
		//JAVA
		LOGGER.info("JAVA Consumer ");
		List<Integer>listaNumero= Arrays.asList(1,2,3,4,5);
		listaNumero.forEach(numero->System.out.println(numero));
		
		
		//Predicate
		
		IPalabraPredicate<String>predicate= new PalabraPredicateImpl();
		LOGGER.info("Predicate Clase: "+predicate.testInicial("Zamora"));
		
		IPalabraPredicate<String>pridicateLambda=inicial-> inicial.startsWith("No");
		LOGGER.info("Predicate Lambda "+pridicateLambda.testInicial("Nobita"));
		
		boolean respuesta=metodosHo.consumirPredicate(inicial-> inicial.startsWith("Zu"), "Zuneo");
		LOGGER.info("HO Predicate: "+respuesta);
		
		
		//JAVA
		LOGGER.info("JAVA Predicate");
		Stream<Integer>nuevaLista=listaNumero.stream().filter(numero->prueba(numero));
		nuevaLista.forEach(numero-> System.out.println(numero));
		
		
		//Function
		
		INumeroFunction<Integer,Boolean>function=new NumeroFunctionImpl();
		LOGGER.info("Function Clase: "+function.aplicarTransformacion(true));
		
		INumeroFunction<Integer,Boolean>functionLambda=verdad->verdad.compareTo(true);
		LOGGER.info("Function Lambda "+ functionLambda.aplicarTransformacion(true));
		
		Integer valorIntegerHo=metodosHo.consumirFunction(verdad->verdad.compareTo(false), false);
		LOGGER.info("Function HO "+valorIntegerHo);
		
		//JAVA
		LOGGER.info("JAVA Function");
		//Conversiones/Cast empleado -> empleado liger
		Stream<String> listaCambiada=listaNumero.stream().map(numeroLista->{
			
			Integer valor=numeroLista+1;
			String cadena="num: "+valor.toString();
			return cadena;
			});
		
		//DELCARATIVA idea/intencion
		listaCambiada.forEach(valor->imprimir(valor));
		
//		List<String>lista1=new ArrayList<>();
//		Map<String, String> mpa1=new HashMap<String, String>();
//		
//		
		
		//IMPERATIVA paso a paso
//		for(String valor:listaCambiada) {
//			imprimir(valor);
//		}
//		
		
		//Unary Operator
		
		ILetraUnary<String>unary=new LetraUnaryImpl();
		LOGGER.info("Unary Clase: "+unary.applyMayuscula("queso", "MARCO"));
		
		ILetraUnary<String>unaryLambda=(String a, String b)->a.toLowerCase()+b.toUpperCase();
		LOGGER.info("Unary Lambda: "+unaryLambda.applyMayuscula("QUESO", "marco"));
	
		String mensaje=metodosHo.consumirUnary((String a, String b)->a.toLowerCase()+b.toUpperCase(), "Maria", "Marcelo");
		LOGGER.info("HO Unary "+mensaje );
		
		
	}

}
