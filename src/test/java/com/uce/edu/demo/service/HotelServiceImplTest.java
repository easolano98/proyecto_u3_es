package com.uce.edu.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.uce.edu.demo.repository.modelo.Hotel;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Transactional
class HotelServiceImplTest {

	@Autowired
	private IHotelService iHotelService;

	@Test
	@Rollback(true)
	public void insertarHotelTest() {
		Hotel hotel = new Hotel();
		hotel.setDireccion("Quito");
		hotel.setNombre("Hotel Luca");

		this.iHotelService.insertar(hotel);

		assertNotNull(hotel.getDireccion(), hotel.getNombre());
	}

	@Test
	@Rollback(true)
	public void actualizarHotelTest() {

		assertThat(this.iHotelService.actualizarHotel("Hotel Latacunga", "Malecon")>0).isTrue();
	}

	@Test
	@Rollback(true)
	public void eliminarHotelTest() {

		assertThat(this.iHotelService.eliminarHotel("Quito")>0).isTrue();
	}

	@Test
	public void buscarHotelJoinFetchTest() {
		
		assertThat(this.iHotelService.buscarHotelJoinFetch("Matrimonial")).isNotEmpty();
	}

	@Test
	public void buscarHotelInnerJoinTest() {
		assertThat(this.iHotelService.buscarHotelInnerJoin("Familiar")).isNotEmpty();
	}

	@Test
	public void buscarHotelOuterJoinLeftTest() {
		assertThat(this.iHotelService.buscarHotelOuterJoinLeft("Matrimonial")).isNotEmpty();
	}

	@Test
	public void buscarHotelOuterJoinRightTest() {
		assertThat(this.iHotelService.buscarHotelOuterJoinRight("Familiar")).isNotEmpty();
	}
}
