package uy.com.bps.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uy.com.bps.model.Cliente;
import uy.com.bps.service.ClienteService;


@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping(path = "api/v1/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	
	@GetMapping("/nomape/{nomcliente}/{apecliente}")
	public ResponseEntity<List<Cliente>>filtroClientexNomApe(
			@PathVariable("nomcliente")String nomcliente, 
			@PathVariable("apecliente") String apecliente){
		List<Cliente> clientes = new ArrayList<Cliente>();
		clienteService.obtenerxNombre(nomcliente, apecliente).forEach(clientes::add);
		if(clientes.isEmpty()) {
			return new ResponseEntity<List<Cliente>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}
	
	
	@GetMapping("/pageable")
	public ResponseEntity<?> paginacionClientesxNombre(@RequestParam String nombre, 
			Pageable pageable){
		Page<Cliente> clientes  = clienteService.paginacionClientexNombre(nombre, pageable);
		if(clientes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}

}
