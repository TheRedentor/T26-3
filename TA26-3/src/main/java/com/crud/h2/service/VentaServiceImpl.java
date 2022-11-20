package com.crud.h2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.h2.dao.IVentaDAO;
import com.crud.h2.dto.Venta;

@Service
public class VentaServiceImpl implements IVentaService {

	@Autowired
	IVentaDAO iVentaDAO;
	
	@Override
	public List<Venta> listarVenta() {
		
		return iVentaDAO.findAll();
	}

	@Override
	public Venta guardarVenta(Venta venta) {

		return iVentaDAO.save(venta);
	}

	@Override
	public Venta ventaXID(int codigo_venta) {

		return iVentaDAO.findById(codigo_venta).get();
	}

	@Override
	public Venta actualizarVenta(Venta venta) {

		return iVentaDAO.save(venta);
	}

	@Override
	public void eliminarVenta(int codigo_venta) {

		iVentaDAO.deleteById(codigo_venta);
		
	}

}
