package com.uce.edu.demo.supermaxi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.supermaxi.repository.modelo.Detalle;
@Repository
@Transactional
public class DetalleRepositoryImpl implements IDetalleRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value=TxType.MANDATORY)
	public void insertar(Detalle detalle) {
		// TODO Auto-generated method stub
		this.entityManager.persist(detalle);
	}

}