package com.ipartek.spring.elpisito.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.spring.elpisito.apirest.exceptions.RecursoNoEncontradoException;
import com.ipartek.spring.elpisito.apirest.models.dao.ProvinciaDAO;
import com.ipartek.spring.elpisito.apirest.models.entities.Provincia;

@Service
public class ProvinciaServiceImpl implements GeneralService<Provincia>{

	@Autowired
	ProvinciaDAO provinciaDao;
	
	@Override
	public Provincia findById(Long id) {
		return provinciaDao.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("No se ha encontrado la provincia con id " + id));
	}

	@Override
	public List<Provincia> findAll() {
		return provinciaDao.findAll();
	}

	@Override
	public Provincia save(Provincia tipo) {
		return provinciaDao.save(tipo);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Provincia> findAllActivo() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
