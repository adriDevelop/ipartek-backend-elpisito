package com.ipartek.spring.elpisito.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.spring.elpisito.apirest.exceptions.RecursoNoEncontradoException;
import com.ipartek.spring.elpisito.apirest.models.dao.InmuebleDAO;
import com.ipartek.spring.elpisito.apirest.models.dao.LocalidadDAO;
import com.ipartek.spring.elpisito.apirest.models.dao.OperacionDAO;
import com.ipartek.spring.elpisito.apirest.models.dao.TipoDAO;
import com.ipartek.spring.elpisito.apirest.models.entities.Inmueble;
import com.ipartek.spring.elpisito.apirest.models.entities.Localidad;
import com.ipartek.spring.elpisito.apirest.models.entities.Operacion;
import com.ipartek.spring.elpisito.apirest.models.entities.Tipo;

@Service
public class InmuebleServiceImpl implements GeneralService<Inmueble> {

	@Autowired
	private InmuebleDAO inmuebleDao;
	@Autowired
	private TipoDAO tipoDao;
	@Autowired
	private OperacionDAO operacionDao;
	@Autowired
	private LocalidadDAO localidadDao;
	
	@Override
	public Inmueble findById(Long id) {
		return inmuebleDao.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("No se ha podido encontrar el inmueble con id " + id));
	}

	@Override
	public List<Inmueble> findAll() {
		return inmuebleDao.findAll();
	}

	@Override
	public Inmueble save(Inmueble tipo) {
		return inmuebleDao.save(tipo);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Inmueble> findAllActivo() {
		return inmuebleDao.findByActivo(1);
	}
	
	public List<Inmueble> findAllPortada(){
		return inmuebleDao.findByActivoAndPortada(1, 1);
	}
	
	public List<Inmueble> finder(Long idTipo, Long idOperacion, Long idLocalidad){
		Tipo tipo = tipoDao.findById(idTipo).orElseThrow(() -> new RecursoNoEncontradoException("No se ha encontrado el tipo con id " + idTipo));
		Operacion operacion = operacionDao.findById(idOperacion).orElseThrow(() -> new RecursoNoEncontradoException("No se ha encontrado la operacion con id " + idOperacion));
		Localidad localidad = localidadDao.findById(idLocalidad).orElseThrow(() -> new RecursoNoEncontradoException("No se ha encontrado la localidad con id " + idLocalidad));
		return inmuebleDao.findByTipoAndActivoAndOperacionAndLocalidad(tipo, 1, operacion, localidad);
	}

}
