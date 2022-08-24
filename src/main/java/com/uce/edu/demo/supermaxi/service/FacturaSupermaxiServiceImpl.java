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
import com.uce.edu.demo.supermaxi.repository.IDetalleRepository;
import com.uce.edu.demo.supermaxi.repository.IFacturaElectronicaRepository;
import com.uce.edu.demo.supermaxi.repository.IFacturaRepository;
import com.uce.edu.demo.supermaxi.repository.IProductoRepository;
import com.uce.edu.demo.supermaxi.repository.modelo.Detalle;
import com.uce.edu.demo.supermaxi.repository.modelo.Factura;
import com.uce.edu.demo.supermaxi.repository.modelo.FacturaElectronica;
import com.uce.edu.demo.supermaxi.repository.modelo.Producto;

@Service
public class FacturaSupermaxiServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository facturaRepository;

	@Autowired
	private IProductoRepository productoRepository;

	@Autowired
	private IClienteRepository clienteRepo;

	@Autowired
	private IDetalleRepository detalleRepository;

	@Autowired
	private IFacturaElectronicaRepository electronicaRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public Factura generar(String cedula, String numeroFactura, List<String> codigos) {
		// TODO Auto-generated method stub
		List<Detalle> detalles = new ArrayList<>();

		Factura fact = new Factura();
		fact.setNumero(numeroFactura);
		fact.setCliente(this.clienteRepo.buscar(cedula));
		fact.setFecha(LocalDateTime.now());
		this.facturaRepository.insertar(fact);
		for (String codigoProd : codigos) {
			Detalle deta = new Detalle();
			deta.setCantidad(1);
			deta.setFactura(fact);
			Producto producto = this.productoRepository.buscar(codigoProd);
			deta.setProducto(producto);
			deta.setSubtotal(deta.getProducto().getPrecio());
			producto.setStock(producto.getStock() - deta.getCantidad());
			this.productoRepository.actualizar(producto);
			detalles.add(deta);
			this.detalleRepository.insertar(deta);

		}
		fact.setDetalles(detalles);
		return fact;

	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void generarFachada(String cedula, String numeroFactura, List<String> codigos) {
		// TODO Auto-generated method stub
		Factura facturaFachada = this.generar(cedula, numeroFactura, codigos);
		BigDecimal totalPagar = new BigDecimal(0);

		FacturaElectronica factElectronica = new FacturaElectronica();
		factElectronica.setNumeroItem(facturaFachada.getDetalles().size());
		factElectronica.setFecha(LocalDateTime.now());
		factElectronica.setNumero(numeroFactura);
		for (Detalle detalle : facturaFachada.getDetalles()) {
			totalPagar = totalPagar.add(detalle.getSubtotal());
		}
		factElectronica.setMonto(totalPagar);
		try {
			this.electronicaRepository.insertar(factElectronica);
		} catch (Exception e) {

		}

	}

}
