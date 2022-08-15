package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService{
	
	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
	
	@Override
	public CuentaBancaria buscarPorNumero(String numeroCta) {
		// TODO Auto-generated method stub
		return this.bancariaRepository.buscarPorNumero(numeroCta);
	}

}
