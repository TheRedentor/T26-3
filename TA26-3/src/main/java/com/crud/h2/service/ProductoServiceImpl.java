package com.crud.h2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.h2.dao.IProductoDAO;
import com.crud.h2.dto.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	IProductoDAO iProductoDAO;
	
	@Override
	public List<Producto> listarProductos() {
		
		return iProductoDAO.findAll();
	}

	@Override
	public Producto guardarProducto(Producto producto) {
		
		return iProductoDAO.save(producto);
	}

	@Override
	public Producto productoXID(int codigo_producto) {
		
		return iProductoDAO.findById(codigo_producto).get();
	}
	

	@Override
	public Producto actualizarProducto(Producto producto) {
		
		return iProductoDAO.save(producto);
	}

	@Override
	public void eliminarProducto(int codigo_producto) {
		
		iProductoDAO.deleteById(codigo_producto);
		
	}

}
