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
		List<Hotel> listaHoteles = this.hotelService.buscarHotelInnerJoin("Matrimonial");

		LOGGER.info("Inner Join");
		for (Hotel h : listaHoteles) {
			LOGGER.info("Hoteles: " + h.getDireccion() + " " + h.getDireccion());
		}
		
		List<Hotel> listaHoteles2 = this.hotelService.buscarHotelInnerJoin();

		for (Hotel h : listaHoteles2) {
			LOGGER.info("Hoteles: " + h.getDireccion() + " " + h.getDireccion());
		}
		
		
		
		LOGGER.info("Left Join");

		List<Hotel> listaHotelesLeft = this.hotelService.buscarHotelOuterJoinLeft("Matrimonial");

		for (Hotel h : listaHotelesLeft) {
			LOGGER.info("Hoteles: " + h.getDireccion() + " " + h.getDireccion());
		}
		
		List<Hotel> listaHotelesLeft2 = this.hotelService.buscarHotelOuterJoinLeft();

		for (Hotel h : listaHotelesLeft2) {
			LOGGER.info("Hoteles: " + h.getDireccion() + " " + h.getDireccion());
		}

		
		
		LOGGER.info("Right Join");

		List<Hotel> listaHotelesRight = this.hotelService.buscarHotelOuterJoinRight("Matrimonial");

		for (Hotel h : listaHotelesRight) {
			LOGGER.info("Hoteles: " + h.getDireccion() + " " + h.getDireccion());
		}

	}

}
