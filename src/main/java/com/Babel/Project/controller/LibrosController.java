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

import com.Babel.Project.model.LibrosDTO;
import com.Babel.Project.service.LibrosService;

@RestController
@RequestMapping("/libros/")
public class LibrosController {
	
	@Autowired
	private LibrosService librosService;
	
	@PostMapping
	private ResponseEntity<LibrosDTO> saveLocacion(@RequestBody LibrosDTO libroDto){
		try {
			librosService.guardarLibro(libroDto);
			return ResponseEntity.created(new URI("/locaciones/" + libroDto.getIdLibro())).body(libroDto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping
	private ResponseEntity<List<LibrosDTO>> getAllLocaciones(){
		return ResponseEntity.ok(librosService.obtenerlibros());
	}
	
	@DeleteMapping(value= "delete/{idLibro}")
	private ResponseEntity<Boolean> deleteLocacion(@PathVariable("idLibro") Long idLibro){
		
		
			librosService.eliminarLocacion(idLibro);
			return ResponseEntity.ok(!(librosService.findById(idLibro) != null));
		
	}

}
