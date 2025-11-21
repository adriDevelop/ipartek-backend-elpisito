package com.ipartek.spring.elpisito.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipartek.spring.elpisito.apirest.models.entities.Tipo;

public interface TipoDAO extends JpaRepository<Tipo, Long>{

}
