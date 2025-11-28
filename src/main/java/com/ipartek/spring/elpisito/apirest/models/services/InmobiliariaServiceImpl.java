package com.ipartek.spring.elpisito.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.spring.elpisito.apirest.exceptions.RecursoNoEncontradoException;
import com.ipartek.spring.elpisito.apirest.models.dao.InmobiliariaDAO;
import com.ipartek.spring.elpisito.apirest.models.entities.Inmobiliaria;

@Service
public class InmobiliariaServiceImpl implements GeneralService<Inmobiliaria> {

	@Autowired
	InmobiliariaDAO inmobiliariaDao;
	
	@Override
	public Inmobiliaria findById(Long id) {
		return inmobiliariaDao.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("No se ha podido encontrar inmobiliaria con id " + id));
	}

	@Override
	public List<Inmobiliaria> findAll() {
		return inmobiliariaDao.findAll();
	}

	@Override
	public Inmobiliaria save(Inmobiliaria tipo) {
		return inmobiliariaDao.save(tipo);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Inmobiliaria> findAllActivo() {
		return inmobiliariaDao.findByActivo(1);
	}

}
