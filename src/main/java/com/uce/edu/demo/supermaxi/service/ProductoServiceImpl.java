package com.uce.edu.demo.supermaxi.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.supermaxi.repository.IProductoRepository;
import com.uce.edu.demo.supermaxi.repository.modelo.Producto;
@Service
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	private IProductoRepository productoRepository;
	
	
	@Override
	@Transactional(value=TxType.REQUIRED)
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.productoRepository.insertar(producto);
	}

	@Override
	@Transactional(value=TxType.REQUIRED)
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.productoRepository.actualizar(producto);
	}

	@Override
	public Producto buscar(String numero) {
		// TODO Auto-generated method stub
		return this.productoRepository.buscar(numero);
	}

	
	
	
}
