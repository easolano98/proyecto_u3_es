package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;
@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository{
	private static final Logger LOG = Logger.getLogger(CuentaBancariaRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	@Transactional(value=TxType.MANDATORY)
	public void actualizar(CuentaBancaria bancaria) {
		// TODO Auto-generated method stub
		this.entityManager.merge(bancaria);
	}


	@Override
	@Transactional(value=TxType.NOT_SUPPORTED)
	public CuentaBancaria buscarPorNumero(String numeroCta) {
		// TODO Auto-generated method stub
		LOG.info("Transaccion activa repository: "+TransactionSynchronizationManager.isActualTransactionActive());
		TypedQuery<CuentaBancaria>query=this.entityManager.createQuery("SELECT c FROM CuentaBancaria c WHERE c.numero=: datoNumero",CuentaBancaria.class);
		query.setParameter("datoNumero", numeroCta);
		return query.getSingleResult();
	}
}