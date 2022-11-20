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

import com.crud.h2.dto.Venta;
import com.crud.h2.service.VentaServiceImpl;

@RestController
@RequestMapping("/api")
public class VentaController {
	@Autowired
	VentaServiceImpl ventaServiceImpl;
	
	@GetMapping("/ventas")
	public List<Venta> listarVenta(){
		return ventaServiceImpl.listarVenta();
	}
	
	
	@PostMapping("/ventas")
	public Venta salvarVenta(@RequestBody Venta venta) {
		
		return ventaServiceImpl.guardarVenta(venta);
	}
	
	
	@GetMapping("/ventas/{codigo_venta}")
	public Venta ventaXID(@PathVariable(name="codigo_venta") int codigo_venta) {
		
		Venta venta_xid= new Venta();
		
		venta_xid=ventaServiceImpl.ventaXID(codigo_venta);
		
		System.out.println("Venta XID: "+venta_xid);
		
		return venta_xid;
	}
	
	@PutMapping("/ventas/{codigo_venta}")
	public Venta actualizarVenta(@PathVariable(name="codigo_venta")int codigo_venta,@RequestBody Venta venta) {
		
		Venta venta_seleccionado= new Venta();
		Venta venta_actualizado= new Venta();
		
		venta_seleccionado= ventaServiceImpl.ventaXID(codigo_venta);
		
		venta_seleccionado.setCajero(venta.getCajero());
		venta_seleccionado.setProducto(venta.getProducto());
		venta_seleccionado.setMaquinaRegistradora(venta.getMaquinaRegistradora());
		
		venta_actualizado = ventaServiceImpl.actualizarVenta(venta_seleccionado);
		
		System.out.println("Venta actualizada es: "+ venta_actualizado);
		
		return venta_actualizado;
	}
	
	@DeleteMapping("/ventas/{codigo_venta}")
	public void eliminarVenta(@PathVariable(name="codigo_venta")int codigo_venta) {
		ventaServiceImpl.eliminarVenta(codigo_venta);
	}
}
