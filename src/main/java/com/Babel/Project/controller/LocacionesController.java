package com.Babel.Project.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Babel.Project.model.LocacionesDTO;
import com.Babel.Project.service.LocacionesService;

@RestController
@RequestMapping("/locaciones/")
public class LocacionesController {
	@Autowired
	private LocacionesService locacionesService;
	
	@GetMapping
	private ResponseEntity<List<LocacionesDTO>> getAllLocaciones(){
		return ResponseEntity.ok(locacionesService.obtenerLocaciones());
	}
	
	@PostMapping
	private ResponseEntity<LocacionesDTO> saveLocacion(@RequestBody LocacionesDTO locacion){
		try {
			locacionesService.guardarLocacion(locacion);
			return ResponseEntity.created(new URI("/locaciones/" + locacion.getIdLocacion())).body(locacion);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping(value= "delete/{idLocacion}")
	private ResponseEntity<Boolean> deleteLocacion(@PathVariable("idLocacion") Long idLocacion){
		
		
			locacionesService.eliminarLocacion(idLocacion);
			return ResponseEntity.ok(!(locacionesService.findById(idLocacion) != null));
		
	}
}
