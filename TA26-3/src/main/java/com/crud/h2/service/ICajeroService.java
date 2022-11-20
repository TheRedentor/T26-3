package com.crud.h2.service;

import java.util.List;

import com.crud.h2.dto.Cajero;

public interface ICajeroService {
	
	public List<Cajero> listarCajeros();
	
	public Cajero guardarCajero(Cajero cajero);
	
	public Cajero actualizarCajero(Cajero cajero);
	
	public void eliminarCajero(int codigo_cajero);

	public Cajero cajeroXID(int codigo_cajero);
	
}
