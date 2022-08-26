package com.uce.edu.demo.tarea.service.funcional;

import java.math.BigDecimal;

public class PrecioIvaConsumerImpl implements IPrecioIvaConsumer<BigDecimal> {

	@Override
	public void acceptIva(BigDecimal arg1) {
		// TODO Auto-generated method stub
		BigDecimal iva= arg1.multiply(new BigDecimal(12).divide(new BigDecimal(100)));
		System.out.println("El iva de su producto es "+iva);
	}
	
	
	
}
