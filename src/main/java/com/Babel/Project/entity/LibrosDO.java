package com.Babel.Project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "libros")
public class LibrosDO{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLibro;
	
	private String titulo;
	
	private String Volumen;

	@ManyToOne
	@JoinColumn(name = "id_locacion")
	private LocacionesDO locacion;
}
