package com.uce.edu.demo.cajero.service;

import java.util.List;

import com.uce.edu.demo.cajero.repository.modelo.Factura;

public interface IFacturaService {

	public List<Factura> buscarFacturaInnerJoin(Integer cantidad);

	public List<Factura> buscarFacturaInnerJoin();

	public List<Factura> buscarFacturaJoinLeft(Integer cantidad);

	public List<Factura> buscarFacturaJoinLeft();

	public List<Factura> buscarFacturaJoinRight(Integer cantidad);

	public List<Factura> buscarFacturaJoinRight();
	
	public List<Factura> buscarFacturaJoinWhere(Integer cantidad);
	
	public List<Factura> buscarFacturaJoinFetch(Integer cantidad);

}
