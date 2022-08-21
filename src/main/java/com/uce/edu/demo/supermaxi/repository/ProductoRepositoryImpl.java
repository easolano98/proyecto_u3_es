package com.uce.edu.demo.supermaxi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.supermaxi.repository.modelo.Producto;
@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	@Transactional(value=TxType.MANDATORY)
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(producto);
	}


	@Override
	@Transactional(value=TxType.MANDATORY)
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);
	}


	@Override
	@Transactional(value=TxType.NOT_SUPPORTED)
	public Producto buscar(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Producto>query=this.entityManager.createQuery("SELECT p FROM Producto1 p WHERE p.numero=: datoNumero", Producto.class);
		query.setParameter("datoNumero", numero);
		return query.getSingleResult();
	}
		
}
