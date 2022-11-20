package com.crud.h2.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ventas")
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_venta;
	
	@ManyToOne
    @JoinColumn(name="codigo_cajero")
    private Cajero cajero;
	
	@ManyToOne
    @JoinColumn(name="codigo_producto")
    private Producto producto;
	
	@ManyToOne
    @JoinColumn(name="codigo_maquina_registradora")
    private MaquinaRegistradora maquina_registradora;
	
	public Venta() {
		
	}

	/**
	 * @param codigo_venta
	 * @param cajero
	 * @param producto
	 * @param maquina_registradora
	 */
	public Venta(int codigo_venta, Cajero cajero, Producto producto, MaquinaRegistradora maquina_registradora) {
		//super();
		this.codigo_venta = codigo_venta;
		this.cajero = cajero;
		this.producto = producto;
		this.maquina_registradora = maquina_registradora;
	}

	
	//Getters y Setters
	
	/**
	 * @return codigo_venta
	 */
	public int codigo_venta() {
		return codigo_venta;
	}

	/**
	 * @param codigo_venta
	 */
	public void setId(int codigo_venta) {
		this.codigo_venta = codigo_venta;
	}
	
	/**
	 * @return cajero
	 */
	public Cajero getCajero() {
		return cajero;
	}

	/**
	 * @param cajero
	 */
	public void setCajero(Cajero cajero) {
		this.cajero = cajero;
	}
	
	/**
	 * @return producto
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * @param producto
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	/**
	 * @return maquina_registradora
	 */
	public MaquinaRegistradora getMaquinaRegistradora() {
		return maquina_registradora;
	}

	/**
	 * @param maquina_registradora
	 */
	public void setMaquinaRegistradora(MaquinaRegistradora maquina_registradora) {
		this.maquina_registradora = maquina_registradora;
	}
	
	
	//Metodo impresion de datos por consola
	@Override
	public String toString() {
		return "Venta [codigo_venta=" + codigo_venta + ", cajero=" + cajero + ", producto=" + producto + ", maquina_registradora=" + maquina_registradora + "]";
	}
	
}
