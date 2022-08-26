package com.uce.edu.demo.tarea.service.funcional;

public class LetraUnaryImpl implements ILetraUnary<String>{

	@Override
	public String applyMayuscula(String arg1, String arg2) {
		// TODO Auto-generated method stub
		String mayusArg1=arg1.toUpperCase();
		String minusArg2=arg2.toLowerCase();
		
		
		return mayusArg1+"-----"+minusArg2;
	}
	

}
