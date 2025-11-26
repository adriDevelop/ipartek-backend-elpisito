package com.ipartek.spring.elpisito.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipartek.spring.elpisito.apirest.models.entities.Inmueble;
import com.ipartek.spring.elpisito.apirest.models.entities.Localidad;
import com.ipartek.spring.elpisito.apirest.models.entities.Operacion;
import com.ipartek.spring.elpisito.apirest.models.entities.Tipo;

@Repository
public interface InmuebleDAO extends JpaRepository<Inmueble, Long>{

	List<Inmueble> findByActivo(Integer estaActivo);
	List<Inmueble> findByActivoAndPortada(Integer estaActivo, Integer estaPortada);
	List<Inmueble> findByTipoAndActivoAndOperacionAndLocalidad(Tipo tipo, Integer estaActivo, Operacion operacion, Localidad localidad);
}
