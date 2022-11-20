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

import com.crud.h2.dto.MaquinaRegistradora;
import com.crud.h2.service.MaquinaRegistradoraServiceImpl;

@RestController
@RequestMapping("/api")
public class MaquinaRegistradoraController {
	@Autowired
	MaquinaRegistradoraServiceImpl maquinaRegistradoraServiceImpl;
	
	@GetMapping("/maquinas_registradoras")
	public List<MaquinaRegistradora> listarMaquinasRegistradoras(){
		return maquinaRegistradoraServiceImpl.listarMaquinasRegistradoras();
	}
	
	
	@PostMapping("/maquinas_registradoras")
	public MaquinaRegistradora salvarMaquinaRegistradora(@RequestBody MaquinaRegistradora maquina_registradora) {
		
		return maquinaRegistradoraServiceImpl.guardarMaquinaRegistradora(maquina_registradora);
	}
	
	
	@GetMapping("/maquinas_registradoras/{codigo_maquina_registradora}")
	public MaquinaRegistradora maquinaRegistradoraXID(@PathVariable(name="codigo_maquina_registradora") int codigo_maquina_registradora) {
		
		MaquinaRegistradora maquina_registradora_xid= new MaquinaRegistradora();
		
		maquina_registradora_xid=maquinaRegistradoraServiceImpl.maquinaRegistradoraXID(codigo_maquina_registradora);
		
		System.out.println("Maquina registradora XID: "+maquina_registradora_xid);
		
		return maquina_registradora_xid;
	}
	
	@PutMapping("/maquinas_registradoras/{codigo_maquina_registradora}")
	public MaquinaRegistradora actualizarMaquinaRegistradora(@PathVariable(name="codigo_maquina_registradora")int codigo_maquina_registradora,@RequestBody MaquinaRegistradora maquina_registradora) {
		
		MaquinaRegistradora maquina_registradora_seleccionado= new MaquinaRegistradora();
		MaquinaRegistradora maquina_registradora_actualizado= new MaquinaRegistradora();
		
		maquina_registradora_seleccionado= maquinaRegistradoraServiceImpl.maquinaRegistradoraXID(codigo_maquina_registradora);
		
		maquina_registradora_seleccionado.setPiso(maquina_registradora.getPiso());
		
		maquina_registradora_actualizado = maquinaRegistradoraServiceImpl.actualizarMaquinaRegistradora(maquina_registradora_seleccionado);
		
		System.out.println("La maquina registradora actualizada es: "+ maquina_registradora_actualizado);
		
		return maquina_registradora_actualizado;
	}
	
	@DeleteMapping("/maquinas_registradoras/{codigo_maquina_registradora}")
	public void eliminarMaquinaRegistradora(@PathVariable(name="codigo_maquina_registradora")int codigo_maquina_registradora) {
		maquinaRegistradoraServiceImpl.eliminarMaquinaRegistradora(codigo_maquina_registradora);
	}
}
