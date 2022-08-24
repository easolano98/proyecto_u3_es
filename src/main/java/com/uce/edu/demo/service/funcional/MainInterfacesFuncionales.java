package com.uce.edu.demo.service.funcional;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {
	private static final Logger LOGGER = Logger.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConsumoMetodosHighOrder metodosHO= new ConsumoMetodosHighOrder();
		
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
		
		//Metodos High Order
		
		String valorHO=metodosHO.consumirSupplier(()->"Hola Mundo");
		LOGGER.info("HO Supplier "+valorHO);
		
		String valorHO1=metodosHO.consumirSupplier(()->{
		String valorConsultado="17128989"	;
		return valorConsultado;});
		LOGGER.info("HO Supplier "+valorHO1);
		
		//CONSUMER
		//Clases
		
		IPersonaConsumer<String> consumerClase=new PersonaConsumerImpl();
		consumerClase.accept("Prueba Consumer");

		//Lambdas
		
		IPersonaConsumer<String>consumerLambda= cadena-> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");
		
		//Metodos High Order
		
		metodosHO.consumirConsumer(valor->System.out.println(valor), 2);
		
		//PREDICATE
		//Clases	
		
		//Lambdas
		IPersonaPredicate<String>predicateLambda= cadena -> cadena.contains("Z");
		LOGGER.info("Predicate Lambdas: "+predicateLambda.evaluar("Erick"));
		
		//Metodos High Order
		
		boolean respuesta=metodosHO.consumirPredicte(cadena-> cadena.contains("E"), "Erick");
		LOGGER.info("HO Predicate: "+respuesta);
		
		//FUNCTION
		//Clases
		
		
		//Lambdas
		//Lo mas comun es para realizar conversiones
		IPersonaFunction<Integer, String>functionLambda= cadena-> {
			Integer valor= Integer.parseInt(cadena);
			Integer valorFinal= valor-2;
			return valorFinal;
			};
		LOGGER.info("Function Lambdas: "+functionLambda.aplicar("7"));

		//Metodos High Order
		String valorFinalHO=metodosHO.consumirFunction(valor-> {
			String retorno=valor.toString()+" A";
			return retorno; 
		}, 117);
		LOGGER.info("HO Function: "+valorFinalHO);
		
		//UNARY OPERATOR (FUNCTION)
		//Clases
		//Lambdas
		IPersonaUnaryOperator<String>unaryLambda= cadena-> {
			String valorFinal= cadena.concat(" sufijo");
			return valorFinal;
		};
		LOGGER.info("Unary Lambdas:"+ unaryLambda.apply("Daniel"));
		
	}

}
