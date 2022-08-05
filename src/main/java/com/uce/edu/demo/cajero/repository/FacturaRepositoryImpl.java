package com.uce.edu.demo.cajero.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.cajero.repository.modelo.Factura;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> query = this.entityManager.createQuery(
				"SELECT f FROM Factura f JOIN f.detalles de WHERE de.cantidad=: datoCantidad", Factura.class);
		query.setParameter("datoCantidad", cantidad);

		return query.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> query = this.entityManager.createQuery(
				"SELECT f FROM Factura f JOIN f.detalles de", Factura.class);

		return query.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaJoinLeft(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> query = this.entityManager.createQuery(
				"SELECT f FROM Factura f LEFT JOIN f.detalles de WHERE de.cantidad=: datoCantidad", Factura.class);
		query.setParameter("datoCantidad", cantidad);

		return query.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaJoinLeft() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> query = this.entityManager.createQuery(
				"SELECT f FROM Factura f LEFT JOIN f.detalles de", Factura.class);

		return query.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaJoinRight(Integer cantidad) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> query = this.entityManager.createQuery(
				"SELECT f FROM Factura f RIGHT JOIN f.detalles de WHERE de.cantidad=: datoCantidad", Factura.class);
		query.setParameter("datoCantidad", cantidad);

		return query.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaJoinRight() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> query = this.entityManager.createQuery(
				"SELECT f FROM Factura f RIGHT JOIN f.detalles de ", Factura.class);

		return query.getResultList();
	}

}
