package com.ipartek.spring.elpisito.apirest.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.spring.elpisito.apirest.models.dao.TipoDAO;
import com.ipartek.spring.elpisito.apirest.models.entities.Tipo;

@Service
public class TipoImpl implements GeneralService<Tipo>{
	
	@Autowired
	private TipoDAO tipoDao;

	@Override
	public Tipo findById(Long id){
		return tipoDao.findById(id).orElseThrow( () -> new RuntimeException("No se ha podido encontrar al usuario") );
	}

	@Override
	public List<Tipo> findAll() {
		return tipoDao.findAll();
	}

	@Override
	public Tipo save(Tipo tipo) {
		return tipoDao.save(tipo);
		
	}

	@Override
	public void deleteById(Long id) throws Exception {
		
		if (!tipoDao.findById(id).isPresent()) {
			throw new Exception("No se ha encontrado al usuario con la id" + id);
		}
		
		tipoDao.deleteById(id);
	}

	@Override
	public List<Tipo> findAllActivo() {
		// TODO Auto-generated method stub
		return null;
	}

}
