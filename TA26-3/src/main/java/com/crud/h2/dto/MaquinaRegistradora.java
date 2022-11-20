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
@Table(name="maquinas_registradoras")
public class MaquinaRegistradora {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_maquina_registradora;
	@Column(name = "piso")
	private int piso;
	
	@OneToMany
    @JoinColumn(name="codigo_maquina_registradora")
    private List<Venta> venta;
	
	public MaquinaRegistradora() {
		
	}

	/**
	 * @param codigo_maquina_registradoraç
	 * @param piso
	 */
	public MaquinaRegistradora(int codigo_maquina_registradora, int piso) {
		//super();
		this.codigo_maquina_registradora = codigo_maquina_registradora;
		this.piso = piso;
	}

	
	//Getters y Setters
	
	/**
	 * @return codigo_maquina_registradora
	 */
	public int getId() {
		return codigo_maquina_registradora;
	}

	/**
	 * @param codigo_maquina_registradora
	 */
	public void setId(int codigo_maquina_registradora) {
		this.codigo_maquina_registradora = codigo_maquina_registradora;
	}
	
	/**
	 * @return piso
	 */
	public int getPiso() {
		return piso;
	}
	
	/**
	 * @param piso
	 */
	public void setPiso(int piso) {
		this.piso = piso;
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
		return "Maquina registradora [codigo_maquina_registradora=" + codigo_maquina_registradora + ", piso=" + piso + "]";
	}
	
}
