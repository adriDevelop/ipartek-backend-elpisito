package com.ipartek.spring.elpisito.apirest.models.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="inmuebles")
public class Inmueble {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String via; // Calle, plaza, carretera, avenida...
	
	@Column(name="nombre_via")
	private String nombreVia;
	
	@Column
	private String claim; // Maravilloso piso!, Fantasticas vistas!
	
	@Column
	private String numero;
	
	@Column
	private String planta;
	
	@Column
	private String puerta;
	
	@Column
	private String apertura; // Interior, exterior, semi-exterior
	
	@Column
	private String orientacion; // Norte, sur, este, oeste, sur-este
	
	@Column(name = "superficie_util")
	private Double superficieUtil;
	
	@Column(name = "superficie_construida")
	private Double superficieConstruida;
	
	@Column
	private Double precio;
	
	@Column
	private String habitaciones;
	
	@Column
	private String banhos;
	
	@Column(length = 3500)
	private String descripcion;
	
	@Column
	private String calefacción;
	
	@Column
	private Integer amueblado; // 1 o 0
	
	@Column
	private String balcones;
	
	@Column
	private String garajes;
	
	@Column
	private Integer piscina; // 1 o 0
	
	@Column
	private Integer trastero; // 1 o 0
	
	@Column
	private Integer jardin; // 1 o 0
	
	@Column
	private Integer tendedero; // 1 o 0
	
	@Column
	private Integer portada = 0; // 1 o 0

	@Column
	private Integer oportunidad = 0; // 1 o 0
	
	@Column
	private Integer gadget = 0;
	
	@Column
	private Integer activo = 1;
	
	@JoinColumn(name = "localidad")
	@ManyToOne
	private Localidad localidad;
	
	@JoinColumn(name = "tipo")
	@ManyToOne
	private Tipo tipo;
	
	@JoinColumn(name = "operacion")
	@ManyToOne
	private Operacion operacion;
	
	@OneToMany(mappedBy = "inmueble")
	private List<ImagenInmueble> imagenesInmueble;
	
	@JoinColumn(name = "inmobiliaria")
	@ManyToOne
	private Inmobiliaria inmobiliaria;
	
	@ManyToMany(mappedBy = "inmueblesFavoritos")
	private List<Usuario> usuariosFavoritos;
	
}
