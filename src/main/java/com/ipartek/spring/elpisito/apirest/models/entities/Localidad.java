package com.ipartek.spring.elpisito.apirest.models.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "localidades")
public class Localidad{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique = true)
	private String nombre;
	
	@Column(unique = true)
	private Integer cp;
	
	@Column
	private Integer activo = 1;
	
	@ManyToOne
	@JoinColumn(name="provincia")
	private Provincia provincia;
	
	@JsonIgnore
	@OneToMany(mappedBy = "localidad")
	private List<Inmueble> inmuebles;
}
