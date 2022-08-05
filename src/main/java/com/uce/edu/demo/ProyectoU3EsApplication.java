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

		LOGGER.info("Inner Join");
		List<Factura> listaFactura = this.facturaService.buscarFacturaInnerJoin(10);
		for (Factura f : listaFactura) {
			LOGGER.info("Factura " + f);

		}

		List<Factura> listaFactura2 = this.facturaService.buscarFacturaInnerJoin();
		for (Factura f : listaFactura2) {
			LOGGER.info("Factura " + f);

		}

		LOGGER.info("Left Join");
		List<Factura> listaFacturaLeft = this.facturaService.buscarFacturaJoinLeft(10);
		for (Factura f : listaFacturaLeft) {
			LOGGER.info("Factura " + f);

		}

		List<Factura> listaFacturaLeft2 = this.facturaService.buscarFacturaJoinLeft();
		for (Factura f : listaFacturaLeft2) {
			LOGGER.info("Factura " + f);

		}

		LOGGER.info("Right Join");
		List<Factura> listaFacturaRight = this.facturaService.buscarFacturaJoinRight(10);
		for (Factura f : listaFacturaRight) {
			LOGGER.info("Factura " + f);

		}

		List<Factura> listaFacturaRight2 = this.facturaService.buscarFacturaJoinRight();
		for (Factura f : listaFacturaRight2) {
			LOGGER.info("Factura " + f);

		}

	}

}
