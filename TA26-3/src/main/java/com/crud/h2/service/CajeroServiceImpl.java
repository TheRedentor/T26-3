package com.crud.h2.service;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.crud.h2.dao.ICajeroDAO;
import com.crud.h2.dto.Cajero;

@Service
public class CajeroServiceImpl implements ICajeroService {
	@Autowired
	ICajeroDAO iCajeroDAO;
	
	@Override
	public List<Cajero> listarCajeros() {
		
		return iCajeroDAO.findAll();
	}

	@Override
	public Cajero guardarCajero(Cajero cajero) {
		
		return iCajeroDAO.save(cajero);
	}

	@Override
	public Cajero cajeroXID(int codigo_cajero) {
		
		return iCajeroDAO.findById(codigo_cajero).get();
	}
	

	@Override
	public Cajero actualizarCajero(Cajero cajero) {
		
		return iCajeroDAO.save(cajero);
	}

	@Override
	public void eliminarCajero(int codigo_cajero) {
		
		iCajeroDAO.deleteById(codigo_cajero);
		
	}
}
