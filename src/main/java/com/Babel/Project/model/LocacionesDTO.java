package com.Babel.Project.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class LocacionesDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long idLocacion;
	
	private String sala;
	
	private String librero;
	
	private String estante;
	
	private String posicion;
	
	private Boolean uso;

}
