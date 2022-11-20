package com.crud.h2.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_producto;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "precio")
	private int precio;
	
	@OneToMany
    @JoinColumn(name="codigo_producto")
    private List<Venta> venta;
	
	public Producto() {
		
	}

	/**
	 * @param codigo_producto
	 * @param nombre
	 * @param precio
	 */
	public Producto(int codigo_producto, String nombre, int precio) {
		//super();
		this.codigo_producto = codigo_producto;
		this.nombre = nombre;
		this.precio = precio;
	}

	
	//Getters y Setters
	
	/**
	 * @return codigo_producto
	 */
	public int getId() {
		return codigo_producto;
	}

	/**
	 * @param codigo_producto
	 */
	public void setId(int codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	/**
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @return precio
	 */
	public int getPrecio() {
		return precio;
	}
	
	/**
	 * @param precio
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	/**
	 * @return venta
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Venta")
	public List<Venta> getVenta() {
		return venta;
	}

	/**
	 * @param venta
	 */
	public void setVenta(List<Venta> venta) {
		this.venta = venta;
	}
	
	
	//Metodo impresion de datos por consola
	@Override
	public String toString() {
		return "Producto [codigo_producto=" + codigo_producto + ", nombre=" + nombre + ", precio=" + precio + "]";
	}
	
}
