package com.crud.h2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.h2.dao.IMaquinaRegistradoraDAO;
import com.crud.h2.dto.MaquinaRegistradora;

@Service
public class MaquinaRegistradoraServiceImpl implements IMaquinaRegistradoraService {

	@Autowired
	IMaquinaRegistradoraDAO iMaquinaRegistradoraDAO;
	
	@Override
	public List<MaquinaRegistradora> listarMaquinasRegistradoras() {
		
		return iMaquinaRegistradoraDAO.findAll();
	}

	@Override
	public MaquinaRegistradora guardarMaquinaRegistradora(MaquinaRegistradora maquina_registradora) {
		
		return iMaquinaRegistradoraDAO.save(maquina_registradora);
	}

	@Override
	public MaquinaRegistradora maquinaRegistradoraXID(int codigo_maquina_registradora) {
		
		return iMaquinaRegistradoraDAO.findById(codigo_maquina_registradora).get();
	}
	

	@Override
	public MaquinaRegistradora actualizarMaquinaRegistradora(MaquinaRegistradora maquina_registradora) {
		
		return iMaquinaRegistradoraDAO.save(maquina_registradora);
	}

	@Override
	public void eliminarMaquinaRegistradora(int codigo_maquina_registradora) {
		
		iMaquinaRegistradoraDAO.deleteById(codigo_maquina_registradora);
		
	}

}
