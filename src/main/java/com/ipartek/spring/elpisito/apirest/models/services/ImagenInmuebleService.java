package com.ipartek.spring.elpisito.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.spring.elpisito.apirest.exceptions.RecursoNoEncontradoException;
import com.ipartek.spring.elpisito.apirest.models.dao.ImagenInmuebleDAO;
import com.ipartek.spring.elpisito.apirest.models.entities.ImagenInmueble;

@Service
public class ImagenInmuebleService implements GeneralService<ImagenInmueble>{
	
	@Autowired
	private ImagenInmuebleDAO imagenDao;
	
	@Override
	public ImagenInmueble findById(Long id) {
		return imagenDao.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("No ha sido posible encontrar imagen con id " + id));
	}

	@Override
	public List<ImagenInmueble> findAll() {
		return imagenDao.findAll();
	}

	@Override
	public ImagenInmueble save(ImagenInmueble tipo) {
		return imagenDao.save(tipo);
	}

	@Override
	public void deleteById(Long id) {
		imagenDao.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("La imagen que intentas eliminar no existe con id " + id));
		imagenDao.deleteById(id);
	}	

	@Override
	public List<ImagenInmueble> findAllActivo() {
		return imagenDao.findByActivo(1);
	}
	
	

}
