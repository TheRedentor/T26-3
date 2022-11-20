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

import com.crud.h2.dto.Cajero;
import com.crud.h2.service.CajeroServiceImpl;

@RestController
@RequestMapping("/api")
public class CajeroController {
	@Autowired
	CajeroServiceImpl cajeroServiceImpl;
	
	@GetMapping("/cajeros")
	public List<Cajero> listarCajeros(){
		return cajeroServiceImpl.listarCajeros();
	}
	
	
	@PostMapping("/cajeros")
	public Cajero salvarCajero(@RequestBody Cajero cajero) {
		
		return cajeroServiceImpl.guardarCajero(cajero);
	}
	
	
	@GetMapping("/cajeros/{codigo_cajero}")
	public Cajero cajeroXID(@PathVariable(name="codigo_cajero") int codigo_cajero) {
		
		Cajero cajero_xid= new Cajero();
		
		cajero_xid=cajeroServiceImpl.cajeroXID(codigo_cajero);
		
		System.out.println("Cajero XID: "+cajero_xid);
		
		return cajero_xid;
	}
	
	@PutMapping("/cajeros/{codigo_cajero}")
	public Cajero actualizarCajero(@PathVariable(name="codigo_cajero")int codigo_cajero,@RequestBody Cajero cajero) {
		
		Cajero cajero_seleccionado= new Cajero();
		Cajero cajero_actualizado= new Cajero();
		
		cajero_seleccionado= cajeroServiceImpl.cajeroXID(codigo_cajero);
		
		cajero_seleccionado.setNomApels(cajero.getNomApels());
		
		cajero_actualizado = cajeroServiceImpl.actualizarCajero(cajero_seleccionado);
		
		System.out.println("El cajero actualizado es: "+ cajero_actualizado);
		
		return cajero_actualizado;
	}
	
	@DeleteMapping("/cajeros/{codigo_cajero}")
	public void eliminarCajero(@PathVariable(name="codigo_cajero")int codigo_cajero) {
		cajeroServiceImpl.eliminarCajero(codigo_cajero);
	}
}
