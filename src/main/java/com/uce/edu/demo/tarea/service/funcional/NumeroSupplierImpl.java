package com.uce.edu.demo.tarea.service.funcional;

import java.util.Random;

public class NumeroSupplierImpl implements INumeroSupplier<Integer> {

	@Override
	public Integer getGenerarNumero() {
		// TODO Auto-generated method stub
		
		return new Random().nextInt(10);
	}

	
}
