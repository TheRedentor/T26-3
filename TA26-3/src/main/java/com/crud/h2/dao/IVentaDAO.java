package com.crud.h2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.h2.dto.Venta;

public interface IVentaDAO extends JpaRepository<Venta, Integer> {

}
