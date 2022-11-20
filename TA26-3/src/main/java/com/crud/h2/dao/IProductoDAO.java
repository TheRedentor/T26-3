package com.crud.h2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.h2.dto.Producto;

public interface IProductoDAO extends JpaRepository<Producto, Integer> {
	
}