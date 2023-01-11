package uy.com.bps.controller;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uy.com.bps.model.sp.Empleado;
import uy.com.bps.service.EmpleadoService;

@RestController
@RequestMapping(path = "api/v1/empleado")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@PostMapping("")
	public ResponseEntity<?> crearEmpleado(@RequestBody Empleado empleado){
		return new ResponseEntity<>(empleadoService.registrarEmpleado(empleado), 
				HttpStatus.CREATED);
	}
	

}
