package com.Babel.Project.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Babel.Project.entity.LocacionesDO;
import com.Babel.Project.model.LocacionesDTO;
import com.Babel.Project.repository.ILocacionesRepository;

@Service
public class LocacionesService {

	@Autowired
	ILocacionesRepository iLocacionesRepository;

	public List<LocacionesDTO> obtenerLocaciones() {
		List<LocacionesDO> locacionesDOs = iLocacionesRepository.findAll();
		List<LocacionesDTO> locacionesDTOs = new ArrayList<LocacionesDTO>();
		locacionesDOs.stream().forEach((locacion) -> {

			LocacionesDTO locacionNueva = new LocacionesDTO();

			locacionNueva.setIdLocacion(locacion.getIdLocacion());
			locacionNueva.setSala(locacion.getSala());
			locacionNueva.setLibrero(locacion.getLibrero());
			locacionNueva.setEstante(locacion.getEstante());
			locacionNueva.setPosicion(locacion.getPosicion());
			locacionNueva.setUso(locacion.getUso());

			locacionesDTOs.add(locacionNueva);
		});

		return locacionesDTOs;
	}

	public void guardarLocacion(LocacionesDTO locacion) {

		LocacionesDO locacionesDO = new LocacionesDO();

		locacionesDO.setIdLocacion(locacion.getIdLocacion());
		locacionesDO.setSala(locacion.getSala());
		locacionesDO.setLibrero(locacion.getLibrero());
		locacionesDO.setEstante(locacion.getEstante());
		locacionesDO.setPosicion(locacion.getPosicion());
		locacionesDO.setUso(locacion.getUso());

		iLocacionesRepository.save(locacionesDO);

	}
	
	

	public void eliminarLocacion(Long locacion) {

		iLocacionesRepository.deleteById(locacion);

	}
	
	public LocacionesDTO obtenerLocacionPorId(Long idLocacion) {
		
		Optional<LocacionesDO> locacionesDO = iLocacionesRepository.findById(idLocacion);
		
		LocacionesDTO locacionDTO = new LocacionesDTO();

		locacionDTO.setIdLocacion(locacionesDO.get().getIdLocacion());
		locacionDTO.setSala(locacionesDO.get().getSala());
		locacionDTO.setLibrero(locacionesDO.get().getLibrero());
		locacionDTO.setEstante(locacionesDO.get().getEstante());
		locacionDTO.setPosicion(locacionesDO.get().getPosicion());
		locacionDTO.setUso(locacionesDO.get().getUso());
		
		return new LocacionesDTO();
	}
	
	public Optional<LocacionesDO> findById(Long idLocacion) {
		return iLocacionesRepository.findById(idLocacion);
	}
}
