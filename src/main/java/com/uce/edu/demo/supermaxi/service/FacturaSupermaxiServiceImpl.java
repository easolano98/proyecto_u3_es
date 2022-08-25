package com.uce.edu.demo.supermaxi.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.supermaxi.repository.IClienteRepository;
import com.uce.edu.demo.supermaxi.repository.IFacturaRepository;
import com.uce.edu.demo.supermaxi.repository.IProductoRepository;
import com.uce.edu.demo.supermaxi.repository.modelo.Detalle;
import com.uce.edu.demo.supermaxi.repository.modelo.Factura;
import com.uce.edu.demo.supermaxi.repository.modelo.Producto;

@Service
public class FacturaSupermaxiServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository facturaRepository;

	@Autowired
	private IProductoRepository productoRepository;

	@Autowired
	private IClienteRepository clienteRepo;

	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public BigDecimal generar(String cedula, String numeroFactura, List<String> codigos) {
		// TODO Auto-generated method stub
		List<Detalle> detalles = new ArrayList<>();
		BigDecimal totalPagar = new BigDecimal(0);
		Factura fact = new Factura();
		fact.setNumero(numeroFactura);
		fact.setCliente(this.clienteRepo.buscar(cedula));
		fact.setFecha(LocalDateTime.now());
		
		for (String codigoProd : codigos) {
			Detalle deta = new Detalle();
			deta.setCantidad(1);
			deta.setFactura(fact);
			Producto producto = this.productoRepository.buscar(codigoProd);
			deta.setProducto(producto);
			deta.setSubtotal(deta.getProducto().getPrecio());
			totalPagar = totalPagar.add(deta.getSubtotal());
			producto.setStock(producto.getStock() - deta.getCantidad());
			this.productoRepository.actualizar(producto);
			detalles.add(deta);
			//this.detalleRepository.insertar(deta);

		}
		fact.setDetalles(detalles);
		this.facturaRepository.insertar(fact);
		return totalPagar;

	}

	

	

}
