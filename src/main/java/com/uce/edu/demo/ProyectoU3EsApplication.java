package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;
import com.uce.edu.demo.service.ITransferenciaService;

@SpringBootApplication
public class ProyectoU3EsApplication implements CommandLineRunner {
	private static final Logger LOGGER = Logger.getLogger(ProyectoU3EsApplication.class);

	@Autowired
	private IHotelService hotelService;
	
	
	@Autowired
	private ITransferenciaService iTransferenciaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3EsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

//		LOGGER.info("Inner Join FETCH");
//		List<Hotel> listaHotelesFetch = this.hotelService.buscarHotelJoinFetch("Matrimonial");
//		for (Hotel h : listaHotelesFetch) {
//			LOGGER.info("Hoteles 3 : " + h.getNombre() + " " + h.getDireccion());
//			LOGGER.info("Hoteles 3 Habitaciones: " + h.getHabitaciones());}
		
		this.iTransferenciaService.realizarTransferenciaFachada("12454871", "12474871", new BigDecimal(1));
		
	}

}
