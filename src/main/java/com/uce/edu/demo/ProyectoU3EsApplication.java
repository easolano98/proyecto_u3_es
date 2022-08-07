package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.cajero.repository.modelo.Factura;
import com.uce.edu.demo.cajero.service.IFacturaService;

@SpringBootApplication
public class ProyectoU3EsApplication implements CommandLineRunner {
	private static final Logger LOGGER = Logger.getLogger(ProyectoU3EsApplication.class);

	@Autowired
	private IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3EsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		LOGGER.info("Relacionamient WHERE");
		List<Factura> listaFacturas = this.facturaService.buscarFacturaJoinWhere(10);
		for (Factura f : listaFacturas) {
			LOGGER.info("Facturas: " + f);

		}

		LOGGER.info("Inner Join FETCH");
		List<Factura> listaFacturasFetch = this.facturaService.buscarFacturaJoinFetch(10);
		for (Factura f : listaFacturasFetch) {
			LOGGER.info("Facturas: " + f.getNumero() + " " + f.getFecha());
			LOGGER.info("Detalles: " + f.getDetalles());
		}

		LOGGER.info("Inner Join LAZY");
		List<Factura> listaFacturasInnerLazy = this.facturaService.buscarFacturaJoinFetch(10);
		for (Factura f : listaFacturasInnerLazy) {
			LOGGER.info("Facturas: " + f.getNumero() + " " + f.getFecha());
			LOGGER.info("Detalles: " + f.getDetalles());
		}

	}

}
