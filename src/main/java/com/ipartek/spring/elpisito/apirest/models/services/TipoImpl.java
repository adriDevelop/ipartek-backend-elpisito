package com.ipartek.spring.elpisito.apirest.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.spring.elpisito.apirest.models.dao.TipoDAO;
import com.ipartek.spring.elpisito.apirest.models.entities.Tipo;

@Service
public class TipoImpl implements TipoService{
	
	@Autowired
	private TipoDAO tipoDao;

	@Override
	public Optional<Tipo> findById(Long id) throws Exception {
		
		if (!tipoDao.findById(id).isPresent()) {
			throw new Exception("No se ha encontrado al usuario con la id " + id);
		}
		
		return tipoDao.findById(id);
	}

	@Override
	public List<Tipo> findAll() {
		return tipoDao.findAll();
	}

	@Override
	public void save(Tipo tipo) {
		tipoDao.save(tipo);
		
	}

	@Override
	public void deleteById(Long id) throws Exception {
		
		if (!tipoDao.findById(id).isPresent()) {
			throw new Exception("No se ha encontrado al usuario con la id" + id);
		}
		
		tipoDao.deleteById(id);
	}

}
