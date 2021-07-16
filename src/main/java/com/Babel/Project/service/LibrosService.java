package com.Babel.Project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Babel.Project.entity.LibrosDO;
import com.Babel.Project.entity.LocacionesDO;
import com.Babel.Project.model.LibrosDTO;
import com.Babel.Project.model.LocacionesDTO;
import com.Babel.Project.repository.ILibrosRespository;
import com.Babel.Project.repository.ILocacionesRepository;

@Service
public class LibrosService {
	@Autowired
	ILibrosRespository iLibrosRespository;
	
	@Autowired
	ILocacionesRepository iLocacionesRepository;
	
	public List<LibrosDTO> obtenerlibros() {
		List<LibrosDO> librosDOs = iLibrosRespository.findAll();
		List<LibrosDTO> librosDtos = new ArrayList<LibrosDTO>();
		librosDOs.stream().forEach((libros) -> {

			
			
			LibrosDTO librosConsultados = new LibrosDTO();

			librosConsultados.setIdLibro(libros.getIdLibro());
			librosConsultados.setTitulo(libros.getTitulo());
			librosConsultados.setVolumen(libros.getVolumen());
			
			LocacionesDTO locacionDTONew = new LocacionesDTO();
			locacionDTONew.setIdLocacion(libros.getLocacion().getIdLocacion());
			locacionDTONew.setEstante(libros.getLocacion().getEstante());
			locacionDTONew.setLibrero(libros.getLocacion().getLibrero());
			locacionDTONew.setPosicion(libros.getLocacion().getPosicion());
			locacionDTONew.setSala(libros.getLocacion().getSala());
			locacionDTONew.setUso(libros.getLocacion().getUso());
			
			librosConsultados.setLocacion(locacionDTONew);

			librosDtos.add(librosConsultados);
		});

		return librosDtos;
	}
	
	public void guardarLibro(LibrosDTO libro) {

		LibrosDO librosDO = new LibrosDO();

		librosDO.setTitulo(libro.getTitulo());
		librosDO.setVolumen(libro.getVolumen());
		
		LocacionesDO locacionesDO = new LocacionesDO();
		
		locacionesDO.setIdLocacion(libro.getLocacion().getIdLocacion());
		locacionesDO.setSala(libro.getLocacion().getSala());
		locacionesDO.setLibrero(libro.getLocacion().getLibrero());
		locacionesDO.setEstante(libro.getLocacion().getEstante());
		locacionesDO.setPosicion(libro.getLocacion().getPosicion());
		locacionesDO.setUso(true);
		
		librosDO.setLocacion(locacionesDO);
		iLocacionesRepository.save(locacionesDO);
		
		iLibrosRespository.save(librosDO);

	}
	
	public void eliminarLocacion(Long libroDTO) {

		LibrosDO librosDO = iLibrosRespository.getById(libroDTO);
		LocacionesDO locacionesDO = new LocacionesDO();
		
		locacionesDO.setIdLocacion(librosDO.getLocacion().getIdLocacion());
		locacionesDO.setSala(librosDO.getLocacion().getSala());
		locacionesDO.setLibrero(librosDO.getLocacion().getLibrero());
		locacionesDO.setEstante(librosDO.getLocacion().getEstante());
		locacionesDO.setPosicion(librosDO.getLocacion().getPosicion());
		locacionesDO.setUso(false);
		
		iLocacionesRepository.save(locacionesDO);
		
		
		iLibrosRespository.deleteById(libroDTO);

	}
	
	public Optional<LibrosDO> findById(Long idLocacion) {
		return iLibrosRespository.findById(idLocacion);
	}

}
