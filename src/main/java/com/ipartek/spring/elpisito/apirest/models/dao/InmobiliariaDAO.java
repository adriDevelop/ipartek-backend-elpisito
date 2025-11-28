package com.ipartek.spring.elpisito.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipartek.spring.elpisito.apirest.models.entities.Inmobiliaria;

@Repository
public interface InmobiliariaDAO extends JpaRepository<Inmobiliaria, Long> {
	
	List<Inmobiliaria> findByActivo(Integer activo);
}
