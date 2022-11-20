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
@Table(name="cajeros")
public class Cajero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_cajero;
	@Column(name = "nomapels")
	private String nomapels;
	
	@OneToMany
    @JoinColumn(name="codigo_cajero")
    private List<Venta> venta;
	
	public Cajero() {
		
	}

	/**
	 * @param codigo_cajero
	 * @param nomapels
	 */
	public Cajero(int codigo_cajero, String nomapels) {
		//super();
		this.codigo_cajero = codigo_cajero;
		this.nomapels = nomapels;
	}

	
	//Getters y Setters
	
	/**
	 * @return codigo_cajero
	 */
	public int getId() {
		return codigo_cajero;
	}

	/**
	 * @param codigo_cajero
	 */
	public void setId(int codigo_cajero) {
		this.codigo_cajero = codigo_cajero;
	}

	/**
	 * @return nomapels
	 */
	public String getNomApels() {
		return nomapels;
	}

	/**
	 * @param nomapels
	 */
	public void setNomApels(String nomapels) {
		this.nomapels = nomapels;
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
		return "Cajero [codigo_cajero=" + codigo_cajero + ", nomapels=" + nomapels + "]";
	}
}
