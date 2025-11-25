package com.ipartek.spring.elpisito.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.spring.elpisito.apirest.exceptions.RecursoNoEncontradoException;
import com.ipartek.spring.elpisito.apirest.models.dao.LocalidadDAO;
import com.ipartek.spring.elpisito.apirest.models.entities.Localidad;

@Service
public class LocalidadServiceImpl implements GeneralService<Localidad>{
	
	@Autowired
	private LocalidadDAO localidadDao;

	@Override
	public Localidad findById(Long id) {
		return localidadDao.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("No se ha encontrado la localidad con id " + id));
	}

	@Override
	public List<Localidad> findAll() {
		return localidadDao.findAll();
	}

	@Override
	public Localidad save(Localidad tipo) {
		return localidadDao.save(tipo);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Localidad> findAllActivo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
