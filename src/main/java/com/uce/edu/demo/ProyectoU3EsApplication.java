package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3EsApplication implements CommandLineRunner {
	private static final Logger LOGGER = Logger.getLogger(ProyectoU3EsApplication.class);

	@Autowired
	private IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3EsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		LOGGER.info("Relacionamient WHERE");
		List<Hotel> listaHoteles = this.hotelService.buscarHotelJoinWhere("Matrimonial");
		for (Hotel h : listaHoteles) {
			LOGGER.info("Hoteles: " + h.getNombre() + " " + h.getDireccion());
		}

		LOGGER.info("Inner Join EAGER/LAZY");
		List<Hotel> listaHotelesInner = this.hotelService.buscarHotelInnerJoin("Matrimonial");
		for (Hotel h : listaHotelesInner) {
			LOGGER.info("Hoteles 2 : " + h.getNombre() + " " + h.getDireccion());
			LOGGER.info("Hoteles 2 Habitaciones: " + h.getHabitaciones());

		}
		
		LOGGER.info("Inner Join FETCH");
		List<Hotel> listaHotelesFetch = this.hotelService.buscarHotelJoinFetch("Matrimonial");
		for (Hotel h : listaHotelesFetch) {
			LOGGER.info("Hoteles 3 : " + h.getNombre() + " " + h.getDireccion());
			LOGGER.info("Hoteles 3 Habitaciones: " + h.getHabitaciones());

		}

	}

}
