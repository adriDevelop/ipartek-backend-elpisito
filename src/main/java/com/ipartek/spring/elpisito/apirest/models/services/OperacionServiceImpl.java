package com.ipartek.spring.elpisito.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.spring.elpisito.apirest.exceptions.RecursoNoEncontradoException;
import com.ipartek.spring.elpisito.apirest.models.dao.OperacionDAO;
import com.ipartek.spring.elpisito.apirest.models.entities.Operacion;

@Service
public class OperacionServiceImpl implements GeneralService<Operacion>{
	
	@Autowired
	OperacionDAO operacionDao;

	@Override
	public Operacion findById(Long id) {
		return operacionDao.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("No se ha encontrado ninguna operación con id " + id));
	}

	@Override
	public List<Operacion> findAll() {
		return operacionDao.findAll();
	}

	@Override
	public Operacion save(Operacion tipo) {
		return operacionDao.save(tipo);
	}
	
	@Override
	public List<Operacion> findAllActivo(){
		return operacionDao.findByActivo(1);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
