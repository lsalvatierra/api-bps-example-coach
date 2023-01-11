package uy.com.bps.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import uy.com.bps.exception.ResourceNotFoundException;
import uy.com.bps.model.Estado;
import uy.com.bps.service.EstadoService;


@RestController
@RequestMapping("api/v1/estado")
//@CrossOrigin(origins = {"http://bps.gub.uy", "http://jutep.gub.uy"})
//@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class EstadoController  {

	
	@Autowired
	private EstadoService estadoService;
	
	//@CrossOrigin(origins = "*")
	@GetMapping("")
	public ResponseEntity<List<Estado>> obtenerTodo(){
		List<Estado> lstEstados = new ArrayList<>();
		estadoService.obtenerTodo().forEach(lstEstados::add);
		if(lstEstados.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lstEstados, HttpStatus.OK);
	}
	

	
	@GetMapping("/{id}")
	public ResponseEntity<Estado> obtenerEstadoPorId(@PathVariable("id") long id){
		Estado estado = estadoService.obtenerPorId(id)
				.orElseThrow(()-> new ResourceNotFoundException(
						"Estado con ID="+id+", no existe."));
		return new ResponseEntity<Estado>(estado, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Estado> crearEstado(@RequestBody Estado estado){
		Estado nuevoEstado = estadoService.guardar(new Estado(estado.getDescestado()));
		return new ResponseEntity<Estado>(nuevoEstado, HttpStatus.CREATED);	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Estado> actualizarEstado(@PathVariable("id") long id,
			@RequestBody Estado estado){
		Estado actualizarEstado = estadoService.obtenerPorId(id)
				.orElseThrow(() -> new ResourceNotFoundException("Estado con ID="+id+", no existe."
						));
		actualizarEstado.setDescestado(estado.getDescestado());
		return new ResponseEntity<Estado>(estadoService.guardar(actualizarEstado), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarEstado(@PathVariable("id") long id){
		estadoService.obtenerPorId(id)
		.orElseThrow(() -> new ResourceNotFoundException("Estado con ID="+id+", no existe."));
		return ResponseEntity.status(HttpStatus.OK).body(estadoService.eliminarPorId(id));
	}
	
	
	
	
	
	
}
