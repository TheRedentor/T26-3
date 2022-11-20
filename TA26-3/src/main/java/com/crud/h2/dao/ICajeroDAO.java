package com.crud.h2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.h2.dto.Cajero;

public interface ICajeroDAO extends JpaRepository<Cajero, Integer> {

}
