package com.uce.edu.demo.cajero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.cajero.repository.IFacturaRepository;
import com.uce.edu.demo.cajero.repository.modelo.Factura;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository facturaRepository;

	@Override
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaInnerJoin(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaInnerJoin();

	}

	@Override
	public List<Factura> buscarFacturaJoinLeft(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaJoinLeft(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaJoinLeft() {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaJoinLeft();
	}

	@Override
	public List<Factura> buscarFacturaJoinRight(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaJoinRight(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaJoinRight() {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaJoinRight();
	}

	@Override
	public List<Factura> buscarFacturaJoinWhere(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaJoinWhere(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaJoinFetch(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaJoinFetch(cantidad);
	}

}
