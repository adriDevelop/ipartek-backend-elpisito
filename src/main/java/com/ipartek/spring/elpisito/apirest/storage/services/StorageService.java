package com.ipartek.spring.elpisito.apirest.storage.services;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ser.std.CalendarSerializer;
import com.ipartek.spring.elpisito.apirest.exceptions.MultipartTratamientoException;
import com.ipartek.spring.elpisito.apirest.exceptions.MultipartVacioException;
import com.ipartek.spring.elpisito.apirest.exceptions.RecursoNoEncontradoException;
import com.ipartek.spring.elpisito.apirest.exceptions.SubidaFisicaArchivoException;
import com.ipartek.spring.elpisito.apirest.models.dao.ImagenInmuebleDAO;
import com.ipartek.spring.elpisito.apirest.models.dao.InmuebleDAO;
import com.ipartek.spring.elpisito.apirest.models.entities.ImagenInmueble;
import com.ipartek.spring.elpisito.apirest.models.entities.Inmueble;
import com.ipartek.spring.elpisito.apirest.storage.utilities.UtilitiesStorage;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class StorageService {
	
	// Este es el servicio que usaremos para:
	// 1) Crear imagenesInmueble en la base de datos.
	// 2) Crear inmuebles en la base de datos.
	// 3) Crear dos servicios para obtener los archivos:
	// 		Uno de ellos tendra que devolver el archivo directamente.
	//      Uno de ellos tendra que devolver la ruta del archivo.
	// 4) Crear el archivo en el servidor.
	
	// Comencemos. Para ello necesitamos los dao necesarios y servicios necesarios para poder realizarlo todo correctamente.
	@Autowired
	private ImagenInmuebleDAO imagenInmuebleDao; // DAO imagenInmueble
	@Autowired
	private InmuebleDAO inmuebleDao;			 // DAO inmueble
	@Autowired
	private HttpServletRequest request;			 // Servicio que controla las peticiones HTTP
	@Value("${media.location}")
	private String rutaAlmacenamiento;			 // Atributo que guarda la ruta de la carpeta donde se almacenaran las imagenes. Esto lo logramos gracias al Bean Value que lo que hace es que, el valor que le pasemos
												 // dentro tiene que ser la propiedad que hemos definido en nuestro archivo properties.
	
	private Path rootLocation;
	
	// Vale, ahora que ya tenemos todo lo que necesitamos, vamos a empezar con los metodos que tiene este servicio.
	
	// El primer metodo es init() que nos va a inicializar la carpeta. Este metodo se llamara automaticamente cuando el servicio se lance.
	@PostConstruct
	public void init() {
		
		// Lo primero que debemos hacer es obtener la ruta.
		rootLocation = Paths.get(rutaAlmacenamiento);
		
		// Y ahora debemos crear la carpeta.
		try {
			Files.createDirectories(rootLocation);
		}catch(IOException ioe) {
			throw new RecursoNoEncontradoException("No se ha encontrado la ruta donde quieres crear la carpeta");
		}
	}
	
	// Con esto, continuamos con el metodo store() que se va a encargar de almacenar en la base de datos y en la ruta fisica el archivo que se reciba.
	public String store(MultipartFile file, Long idInmueble, String descripcion) {
		
		// Lo primero que comprobara es si el fichero viene con datos.
		if (!file.isEmpty()) {
			throw new MultipartVacioException("El multipart esta vacio");
		}
		
		// Tras esta comprobacion, ahora deberemos de comprobar el tipo mime del archivo y comprobarlo con los mime que son validos.
		List<String> listadoTipoMimesActivos = List.of("image/jpeg", "image/png");
		String tipoMime = UtilitiesStorage.devuelveTipoMime(file, listadoTipoMimesActivos);
		String extensionArchivo = UtilitiesStorage.devuelveExtensionArchivo(tipoMime);
		
		// Una vez tengamos tanto el tipo mime, y la extension del archivo, crearemos el nombre de nuestro archivo y lo concatenaremos con la extension de su archivo.
		String nombreArchivo = String.valueOf(Calendar.getInstance().getTimeInMillis());
		nombreArchivo.concat(extensionArchivo);
		
		// Tenemos que crear el archivo en un fichero fisico de nuestro sistema (servidor)
		try(
				InputStream inputStream = file.getInputStream();
			) {
			
			Files.copy(inputStream, Paths.get(nombreArchivo), StandardCopyOption.REPLACE_EXISTING);
			
		}catch(Exception e) {
			throw new SubidaFisicaArchivoException("Error subiendo el archivo al servidor");
		}
		
		// Cuando tengamos el nombre de nuestro archivo, vamos a crearlo en nuestro rootLocation. Para ello, tenemos que unir la ruta de la cadena y el nombre de nuestro archivo en un Path.
		try{
				ImagenInmueble imagen = new ImagenInmueble();
				Inmueble inmueble = inmuebleDao.findById(idInmueble).orElseThrow(() -> new RecursoNoEncontradoException("No se ha encontrado un inmueble"));
				
				imagen.setNombre(nombreArchivo);
				imagen.setAlt_imagen(descripcion);
				imagen.setInmueble(inmueble);
				
				imagenInmuebleDao.save(imagen);
		}catch(Exception ioe) {
			// Aqui, debemos de borrar el archivo que hemos creado en el paso anterior, para que no se mantenga dentro de nuestro servidor de archivos en mediafiles.
			deleteFileExistente(nombreArchivo);
			throw new MultipartTratamientoException("No se puede crear el archivo");
		}
		
		// Devolvemos el nombre del archivo.
		return nombreArchivo;
	}
	
	// Este metodo se va a encargar de eliminar el archivo buscando la ruta en los archivos que tenemos en nuestro servidor.
	private void deleteFileExistente(String nombreArchivo) {
		
		// Para ello primero necesitamos tener la ruta.
		Path rutaArchivo = rootLocation.resolve(nombreArchivo).normalize();
		
		// Ahora, una vez que tenemos la ruta, tenemos que comprobar que el archivo existe y si existe, lo borramos.
		File ficheroABorrar = rutaArchivo.toFile();
		
		if (!ficheroABorrar.exists()) {
			throw new RecursoNoEncontradoException("No se ha encontrado el fichero en el servidor");
		}
		
		ficheroABorrar.delete();
		
	}
	
	// Ahora, debemos de crear un metodo que se encargara de borrar el fichero en el sistema fisico y eliminar la imagenInmueble de la base de datos.
	public void deleteFileAndBBDD(String nombreArchivo, Long idImagen) {
		
		// Lo primero que debemos de hacer es buscar el archivo en la base de datos.
		imagenInmuebleDao.findById(idImagen).orElseThrow(() -> new RecursoNoEncontradoException("No se ha encontrado la imagen en la base de datos"));
		// Si existe lo prodremos eliminar de la base de datos.
		imagenInmuebleDao.deleteById(idImagen);
		// Y lo podremos eliminar de nuestro servidor fisico.
		deleteFileExistente(nombreArchivo);	
	}
	
	// Tambien, debemos de hacer un metodo que nos devuelve el archivo para poder verlo como un Recurso. Muy importante que devuelva un recurso.
	public Resource devuelveFichero(String nombreArchivo) {
		
		// Lo primero que debemos de hacer es encontrar el fichero en nuestro sistema
		Path rutaCompleta
		
		// Cuando lo tengamos, debemos crear el recurso
		if (ficheroEncontrado.exists() && ficheroEncontrado.canRead()) {
			Resource recurso = Paths.get(ficheroEncontrado.toURI());
		}else {
			throw new RecursoNoEncontradoException("El recurso no es accesible");
		}
	}

}
