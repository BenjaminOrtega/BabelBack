package com.Babel.Project.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class LibrosDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long idLibro;
	
	private String titulo;
	
	private String Volumen;

	private LocacionesDTO locacion;
}
