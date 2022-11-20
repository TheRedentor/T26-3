package com.crud.h2.service;

import java.util.List;

import com.crud.h2.dto.Venta;

public interface IVentaService {
	
	public List<Venta> listarVenta();
	
	public Venta guardarVenta(Venta venta);
	
	public Venta ventaXID(int codigo_venta);
	
	public Venta actualizarVenta(Venta venta);
	
	public void eliminarVenta(int codigo_venta);
	
}
