package com.uce.edu.demo.service.funcional;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {
	private static final Logger LOGGER = Logger.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SUPPLIER
		//Clases
		IPersonaSupplier<String> supplier= new PersonaSupplierImpl();
		LOGGER.info("Suplier Clase: "+supplier.getNombre());
		
		IPersonaSupplier<String> supplierTE= new PersonaSupplierTEImpl();
		LOGGER.info("Suplier Clase: "+supplierTE.getNombre());

		
		//Lambdas
		IPersonaSupplier<String> supplierLambda= ()->"Erick 2";
		LOGGER.info("Suplier Lambdas: "+supplierLambda.getNombre());
		
		IPersonaSupplier<String> supplierLambdaTE= ()->"Danel TE2";
		LOGGER.info("Suplier Lambdas: "+supplierLambdaTE.getNombre());
		
		
		//CONSUMER
		IPersonaConsumer<String> consumerClase=new PersonaConsumerImpl();
		consumerClase.accept("Prueba Consumer");
		
		IPersonaConsumer<String>consumerLambda= cadena-> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");
		
		
		//Clases
		
		
		//Lambdas
		
		//PREDICATE
		//Clases
		
		
		//Lambdas
		
		//FUNCTION
		//Clases
		
		
		//Lambdas
		
		
		
		//UNARY OPERATOR (FUNCTION)
		//Clases
		
		
		//Lambdas
	
	
	}

}
