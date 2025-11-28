package com.ipartek.spring.elpisito.apirest.models.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "inmobiliarias")
public class Inmobiliaria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String nombre;
	
	@Column(unique = true)
	private String telefono;
	
	@Column
	private String representante;
	
	@Column(unique = true)
	private String logo;
	
	@Column
	private Integer activo = 1;
	
	@JsonIgnore
	@OneToMany(mappedBy = "inmobiliaria")
	private List<Inmueble> inmuebles;
	
	

}
