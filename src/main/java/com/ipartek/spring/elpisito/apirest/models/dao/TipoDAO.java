package com.ipartek.spring.elpisito.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipartek.spring.elpisito.apirest.models.entities.Tipo;

@Repository
public interface TipoDAO extends JpaRepository<Tipo, Long>{

}
