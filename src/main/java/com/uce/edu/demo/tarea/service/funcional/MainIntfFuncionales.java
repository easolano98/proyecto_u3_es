package com.uce.edu.demo.tarea.service.funcional;

import java.math.BigDecimal;
import java.util.Random;

import org.apache.log4j.Logger;

public class MainIntfFuncionales {
	private static final Logger LOGGER = Logger.getLogger(MainIntfFuncionales.class);

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
		
		
		//Consumer
		
		IPrecioIvaConsumer<BigDecimal>consumer=new PrecioIvaConsumerImpl();
		consumer.acceptIva(new BigDecimal(15));
		
		
		IPrecioIvaConsumer<BigDecimal>consumerLambda= iva->System.out.println(iva);
		consumerLambda.acceptIva(new BigDecimal(1.35));
		
		metodosHo.consumirConsumer(precio->System.out.println("valor iva HO"+ precio), new BigDecimal(3.25));
		
		//Predicate
		
		IPalabraPredicate<String>predicate= new PalabraPredicateImpl();
		LOGGER.info("Predicate Clase: "+predicate.testInicial("Zamora"));
		
		IPalabraPredicate<String>pridicateLambda=inicial-> inicial.startsWith("No");
		LOGGER.info("Predicate Lambda "+pridicateLambda.testInicial("Nobita"));
		
		boolean respuesta=metodosHo.consumirPredicate(inicial-> inicial.startsWith("Zu"), "Zuneo");
		LOGGER.info("HO Predicate: "+respuesta);
		
		//Function
		
		INumeroFunction<Integer,Boolean>function=new NumeroFunctionImpl();
		LOGGER.info("Function Clase: "+function.aplicarTransformacion(true));
		
		INumeroFunction<Integer,Boolean>functionLambda=verdad->verdad.compareTo(true);
		LOGGER.info("Function Lambda "+ functionLambda.aplicarTransformacion(true));
		
		Integer valorIntegerHo=metodosHo.consumirFunction(verdad->verdad.compareTo(false), false);
		LOGGER.info("Function HO "+valorIntegerHo);
		
		//Unary Operator
		
		ILetraUnary<String>unary=new LetraUnaryImpl();
		LOGGER.info("Unary Clase: "+unary.applyMayuscula("queso", "MARCO"));
		
		ILetraUnary<String>unaryLambda=(String a, String b)->a.toLowerCase()+b.toUpperCase();
		LOGGER.info("Unary Lambda: "+unaryLambda.applyMayuscula("QUESO", "marco"));
	
		String mensaje=metodosHo.consumirUnary((String a, String b)->a.toLowerCase()+b.toUpperCase(), "Maria", "Marcelo");
		LOGGER.info("HO Unary "+mensaje );
	}

}
