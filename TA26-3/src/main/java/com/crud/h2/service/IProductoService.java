package com.crud.h2.service;

import java.util.List;

import com.crud.h2.dto.Producto;

public interface IProductoService {
	
	public List<Producto> listarProductos();
	
	public Producto guardarProducto(Producto producto);
	
	public Producto productoXID(int codigo_producto);
	
	public Producto actualizarProducto(Producto producto);
	
	public void eliminarProducto(int codigo_producto);
	
}
