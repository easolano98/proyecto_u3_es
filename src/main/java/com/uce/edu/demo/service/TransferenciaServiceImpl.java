package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.ITransferenciaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Transferencia;
@Service
public class TransferenciaServiceImpl implements ITransferenciaService {
	
	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
	
	@Autowired
	private ITransferenciaRepository transferenciaRepository;
	
	
	@Override
	@Transactional(value=TxType.REQUIRES_NEW)
	public void realizarTransferencia(String NumeroCtaOrigen, String NumeroCtaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		//0.buscar cuenta origen (obtener el saldo)
		CuentaBancaria ctaOrigen= this.bancariaRepository.buscarPorNumero(NumeroCtaOrigen);
		//1.Restar el monto a la cta Origen
		BigDecimal saldoOrigen=ctaOrigen.getSaldo();
		BigDecimal saldoFinal=saldoOrigen.subtract(monto);
		ctaOrigen.setSaldo(saldoFinal);
		this.bancariaRepository.actualizar(ctaOrigen);
		
		//0.buscar cuenta destino (obtener el saldo)
		CuentaBancaria ctaDestino=this.bancariaRepository.buscarPorNumero(NumeroCtaDestino);
		//2. Sumar el monto a la cta Destino
		ctaDestino.setSaldo(ctaDestino.getSaldo().add(monto));
		this.bancariaRepository.actualizar(ctaDestino);
		
		//3. insertar la transferencia
		Transferencia trans=new Transferencia();
		trans.setFecha(LocalDateTime.now());
		trans.setMonto(monto);
		trans.setCuentaOrigen(ctaOrigen);
		trans.setCuentaDestino(ctaDestino);
		this.transferenciaRepository.insertar(trans);
		
		
	}

	@Override
	@Transactional(value=TxType.REQUIRED)
	public void realizarTransferenciaFachada(String ctaOrigen, String ctaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		this.realizarTransferencia(ctaOrigen, ctaDestino, monto);
	}

}
