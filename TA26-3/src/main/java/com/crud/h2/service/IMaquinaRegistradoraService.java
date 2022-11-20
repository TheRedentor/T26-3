package com.crud.h2.service;

import java.util.List;

import com.crud.h2.dto.MaquinaRegistradora;

public interface IMaquinaRegistradoraService {
	
	public List<MaquinaRegistradora> listarMaquinasRegistradoras();
	
	public MaquinaRegistradora guardarMaquinaRegistradora(MaquinaRegistradora maquina_registradora);
	
	public MaquinaRegistradora maquinaRegistradoraXID(int codigo_maquina_registradora);
	
	public MaquinaRegistradora actualizarMaquinaRegistradora(MaquinaRegistradora maquina_registradora);
	
	public void eliminarMaquinaRegistradora(int codigo_maquina_registradora);
	
}
