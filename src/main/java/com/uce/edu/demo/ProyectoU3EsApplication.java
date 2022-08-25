package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.supermaxi.repository.modelo.Cliente;
import com.uce.edu.demo.supermaxi.repository.modelo.Producto;
import com.uce.edu.demo.supermaxi.service.IClienteService;
import com.uce.edu.demo.supermaxi.service.IFacturaService;
import com.uce.edu.demo.supermaxi.service.IGestorComprasService;
import com.uce.edu.demo.supermaxi.service.IProductoService;

@SpringBootApplication
public class ProyectoU3EsApplication implements CommandLineRunner {
	private static final Logger LOGGER = Logger.getLogger(ProyectoU3EsApplication.class);

	@Autowired
	private IProductoService iProductoService;
	
	@Autowired
	private IGestorComprasService comprasService;
	
	@Autowired
	private IClienteService clienteService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3EsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub


		Cliente cliente=new Cliente();
		cliente.setApellido("Solano");
		cliente.setNombre("Erick");
		cliente.setCedula("1720223031");
		cliente.setNumeroTarjeta("1234567");
		//this.clienteService.insertar(cliente);
		
		
		Producto producto=new Producto();
		producto.setNombre("Coca Cola");
		producto.setNumero("012345");
		producto.setPrecio(new BigDecimal(1.50));
		producto.setStock(50);
		//this.iProductoService.insertar(producto);
		
		Producto producto2=new Producto();
		producto2.setNombre("Cereal Chocapic");
		producto2.setNumero("050301");
		producto2.setPrecio(new BigDecimal(5.00));
		producto2.setStock(75);
		//this.iProductoService.insertar(producto2);
		
		Producto producto3=new Producto();
		producto3.setNombre("Manicho");
		producto3.setNumero("010809");
		producto3.setPrecio(new BigDecimal(0.50));
		producto3.setStock(100);
		//this.iProductoService.insertar(producto3);
		
		List<String>detalles=new ArrayList<>();
		detalles.add(producto.getNumero());
		detalles.add(producto3.getNumero());
		
		
		this.comprasService.generarFacturaElectronicaSRI(cliente.getCedula(), "008", detalles );;
		
		
		
		
		
		
	}

}
