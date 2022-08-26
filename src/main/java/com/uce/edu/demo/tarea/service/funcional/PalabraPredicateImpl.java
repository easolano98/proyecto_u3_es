package com.uce.edu.demo.tarea.service.funcional;

public class PalabraPredicateImpl implements IPalabraPredicate<String>{

	@Override
	public boolean testInicial(String arg1) {
		// TODO Auto-generated method stub
		return arg1.startsWith("Za");
	}
			
}
