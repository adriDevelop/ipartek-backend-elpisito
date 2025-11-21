package com.ipartek.spring.elpisito.apirest.models.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tipo")
public class Tipo implements Serializable{
	
	private static final long serialVersionUID = 7092725578050489645L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String nombre; // Piso, Chalet, Terreno...

}
