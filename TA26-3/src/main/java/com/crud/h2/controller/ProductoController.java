package com.crud.h2.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.h2.dto.Producto;
import com.crud.h2.service.ProductoServiceImpl;

@RestController
@RequestMapping("/api")
public class ProductoController {
	@Autowired
	ProductoServiceImpl productoServiceImpl;
	
	@GetMapping("/productos")
	public List<Producto> listarProductos(){
		return productoServiceImpl.listarProductos();
	}
	
	
	@PostMapping("/productos")
	public Producto salvarProducto(@RequestBody Producto producto) {
		
		return productoServiceImpl.guardarProducto(producto);
	}
	
	
	@GetMapping("/productos/{codigo_producto}")
	public Producto productoXID(@PathVariable(name="codigo_producto") int codigo_producto) {
		
		Producto producto_xid= new Producto();
		
		producto_xid=productoServiceImpl.productoXID(codigo_producto);
		
		System.out.println("Producto XID: "+producto_xid);
		
		return producto_xid;
	}
	
	@PutMapping("/productos/{codigo_producto}")
	public Producto actualizarProducto(@PathVariable(name="codigo_producto")int codigo_producto,@RequestBody Producto producto) {
		
		Producto producto_seleccionado= new Producto();
		Producto producto_actualizado= new Producto();
		
		producto_seleccionado= productoServiceImpl.productoXID(codigo_producto);
		
		producto_seleccionado.setNombre(producto.getNombre());
		producto_seleccionado.setPrecio(producto.getPrecio());
		
		producto_actualizado = productoServiceImpl.actualizarProducto(producto_seleccionado);
		
		System.out.println("El producto actualizado es: "+ producto_actualizado);
		
		return producto_actualizado;
	}
	
	@DeleteMapping("/productos/{codigo_producto}")
	public void eliminarProducto(@PathVariable(name="codigo_producto")int codigo_producto) {
		productoServiceImpl.eliminarProducto(codigo_producto);
	}
}
