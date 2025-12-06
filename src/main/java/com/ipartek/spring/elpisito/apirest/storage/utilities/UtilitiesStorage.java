package com.ipartek.spring.elpisito.apirest.storage.utilities;

import java.io.IOException;
import java.util.List;

import org.apache.tika.Tika;
import org.apache.tika.mime.MimeType;
import org.apache.tika.mime.MimeTypes;
import org.springframework.web.multipart.MultipartFile;

import com.ipartek.spring.elpisito.apirest.exceptions.FormatoNoSoportadoException;
import com.ipartek.spring.elpisito.apirest.exceptions.PeticionMalFormadaException;
import com.ipartek.spring.elpisito.apirest.exceptions.RecursoNoEncontradoException;

public class UtilitiesStorage {

	// Aqui tendremos unos metodos que nos ayudaran en el desarrollo del Servicio del Storage.
	
	// Para comenzar necesitamos un metodo que devuelve el tipo mime formateado y compruebe si el tipo mime es valido.
	public static String devuelveTipoMime(MultipartFile file, List<String> listadoMimesValidos) {
		
		// Necesitamos el nombre del archivo y el tipo mime, asi que vamos a crear unas variables para cada uno.
		String nombreDelArchivo = null;
		String tipoMime = null;
		
		try {
			// Obtenemos el nombre del archivo original y lo convertimos en minusculas.
			nombreDelArchivo = file.getOriginalFilename().toLowerCase();
		}catch(Exception e) {
			throw new RecursoNoEncontradoException("No se ha encontrado el archivo");
		}
		
		try {
			
			// Tenemos que obtener el tipo mime del fichero. Entonces usamos Tika que nos devuelve el tipo Mime con el metodo Detect y file.getInputStream() que 
			// nos devuelve el contenido de ese fichero.
			tipoMime = new Tika().detect(file.getInputStream());
		}catch(Exception e) {
			throw new RecursoNoEncontradoException("No se ha encontrado el archivo");
		}
		
		// Ahora, Tika se encarga de devolvernos el tipo mime, pero puede ser que nos agregue algo a la cadena. Asi que lo formatearemos con el metodo devuelveTipoMimeNormalizado.
		String tipoMimeNormalizado = devuelveTipoMimeNormalizado(tipoMime);
		
		// Con el tipo mime ya normalizado, podemos comprobar si el tipo mime se encuentra dentro de los validos.
		if (!listadoMimesValidos.contains(tipoMimeNormalizado)) {
			throw new PeticionMalFormadaException("El tipo mime que me has mandado no se encuentra entre los validos");
		}
		
		// Retornamos el tipo mime
		return tipoMimeNormalizado;
		
	}
	
	// Tambien, necesitaremos un metodo para devolver la extension del archivo a traves de su tipo mime.
	public static String devuelveExtensionArchivo(String nombreArchivo) {
		
		// Debemos de coger todos los tipo mime que puede haber
		MimeTypes tiposMime = MimeTypes.getDefaultMimeTypes();
		MimeType extension = null;
		
		try {
			// Cogeremos la extension de los tiposMime que hemos declarado antes comparandolo con el nombre del archivo recibido en el parametro.
			extension = tiposMime.forName(nombreArchivo);
		}catch(Exception ioe) {
			throw new FormatoNoSoportadoException("No se ha encontrado la extension para este tipo mime");
		}
		
		return extension.toString();
	}
	
	// Y por ultimo, necesitaremos tambien un metodo que nos facilitara el formateo de nuestro tipo mime
	private static String devuelveTipoMimeNormalizado(String tipoMime) {
		
		// Debemos formatear el tipo mime recibido, asi que vamos a comprobar que no tenga el ; que nos suele devolver tika en sus string.
		// Comprobamos que no lo tenga y si lo tiene, lo quitamos y limpiamos de espacios.
		if (tipoMime.contains(";")) {
			tipoMime = tipoMime.split(";")[0].trim();		
		}
		
		// Devolvemos el tipo mime formateado
		return tipoMime;
	}
	
}
