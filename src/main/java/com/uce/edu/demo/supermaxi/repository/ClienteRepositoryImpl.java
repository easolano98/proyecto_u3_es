package com.uce.edu.demo.supermaxi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.supermaxi.repository.modelo.Cliente;
@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value=TxType.MANDATORY)
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cliente);
	}

	@Override
	@Transactional(value=TxType.NOT_SUPPORTED)
	public Cliente buscar(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Cliente>query=this.entityManager.createQuery("SELECT c FROM Cliente2 c WHERE c.cedula=: datoCedula", Cliente.class);
		query.setParameter("datoCedula", cedula);
		return query.getSingleResult();
	}

	
	
}
