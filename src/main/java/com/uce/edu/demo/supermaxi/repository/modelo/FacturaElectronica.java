package com.uce.edu.demo.supermaxi.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="factura_electronica")
public class FacturaElectronica {

		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fael_id_seq")
		@SequenceGenerator(name = "fael_id_seq", sequenceName = "fael_id_seq", allocationSize = 1)
		@Column(name="fael_id")
		private Integer id;
		@Column(name="fael_fecha")
		private LocalDateTime fecha;
		@Column(name="fael_numero")
		private String numero;
		@Column(name="fael_monto")
		private BigDecimal monto;
		@Column(name="fael_items")
		private Integer numeroItem;
		
		//SET y GET
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public LocalDateTime getFecha() {
			return fecha;
		}
		public void setFecha(LocalDateTime fecha) {
			this.fecha = fecha;
		}
		public String getNumero() {
			return numero;
		}
		public void setNumero(String numero) {
			this.numero = numero;
		}
		public BigDecimal getMonto() {
			return monto;
		}
		public void setMonto(BigDecimal monto) {
			this.monto = monto;
		}
		public Integer getNumeroItem() {
			return numeroItem;
		}
		public void setNumeroItem(Integer numeroItem) {
			this.numeroItem = numeroItem;
		}
		
		
		
		
		
}
