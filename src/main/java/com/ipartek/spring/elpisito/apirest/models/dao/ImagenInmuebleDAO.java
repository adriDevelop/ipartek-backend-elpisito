package com.ipartek.spring.elpisito.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipartek.spring.elpisito.apirest.models.entities.ImagenInmueble;

@Repository
public interface ImagenInmuebleDAO extends JpaRepository<ImagenInmueble, Long>{

	List<ImagenInmueble> findByActivo(Integer id);
	
}
