package com.ipartek.spring.elpisito.apirest.models.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name="usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // IDENTITY es un incremental para MySQL
	@Column
	private Long id;
	
	@Column(unique = true)
	private String nombre;
	
	@Column
	private String password;
	
	@Column
	private String passwordOpen;
	
	@Column(unique = true)
	private String email;
	
	@Column
	private String rol = "ROLE_USER";
	
	@Column
	private Integer activo = 1;
	
	@ManyToMany
	@JoinTable(
			name = "Usuarios_inmuebles",
			joinColumns = { @JoinColumn(name = "id_usuario") },
			inverseJoinColumns = { @JoinColumn(name = "id_inmueble") }
	)
	private Set<Inmueble> inmueblesFavoritos;

}
