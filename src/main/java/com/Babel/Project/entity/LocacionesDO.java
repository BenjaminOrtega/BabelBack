package com.Babel.Project.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "locaciones")
public class LocacionesDO{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLocacion;
	
	private String sala;
	
	private String librero;
	
	private String estante;
	
	private String posicion;
	
	private Boolean uso;
	
}
