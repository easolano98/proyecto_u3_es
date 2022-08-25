package com.uce.edu.demo.supermaxi.service;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class GestorComprasServiceImpl implements IGestorComprasService {
	
	@Autowired
	private IFacturaService facturaService;
	
	@Autowired
	private IFacturaElectronicaService electronicaService;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void generarFacturaElectronicaSRI(String cedula, String numeroFactura, List<String> codigos) {
		// TODO Auto-generated method stub
		BigDecimal totalPagar=this.facturaService.generar(cedula, numeroFactura, codigos);
		
		this.electronicaService.procesarElectronica(numeroFactura, codigos.size(), totalPagar);
		
		
	}
	
	
	
	
	
}
