package com.uce.edu.demo.tarea.service.funcional;

import java.math.BigDecimal;

public class MetodosHighOrderTarea {
	
	public Integer consumirSupplier(INumeroSupplier<Integer>funcion) {
		
		return funcion.getGenerarNumero();
	}
	
	public void consumirConsumer(IPrecioIvaConsumer<BigDecimal>funcion, BigDecimal precio) {
		funcion.acceptIva(precio);
	}
	
	public boolean consumirPredicate(IPalabraPredicate<String>funcion, String palabra) {
		return funcion.testInicial(palabra);
	}
	
	public Integer consumirFunction(INumeroFunction<Integer, Boolean>funcion, Boolean verdad) {
		
		return funcion.aplicarTransformacion(verdad);
	}
	
	public String consumirUnary(ILetraUnary<String>funcion, String palabraA, String palabraB) {
		
		return funcion.applyMayuscula(palabraA, palabraB);
	}
	
	
}
