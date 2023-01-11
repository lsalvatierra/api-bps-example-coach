package uy.com.bps.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uy.com.bps.convertdto.DtoUtil;
import uy.com.bps.dto.DtoEntity;
import uy.com.bps.dto.SalaDto;
import uy.com.bps.model.Sala;
import uy.com.bps.service.SalaService;

@RestController
@RequestMapping(path = "api/v1/sala")
public class SalaController {
	
	@Autowired
	private SalaService salaService;
	
	@GetMapping("/full")
	public ResponseEntity<List<Sala>> obtenerTodos(){
		List<Sala> salas = new ArrayList<Sala>();
		salaService.obtenerTodo().forEach(salas::add);
		if(salas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Sala>>(salas, HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<List<DtoEntity>> obtenerTodoDTO(){
		List<DtoEntity> salas = new ArrayList<DtoEntity>();
		salas = salaService.obtenerTodo()
				.stream().map(x -> new DtoUtil().convertirADto(x, new SalaDto()))
				.collect(Collectors.toList());
		if(salas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<DtoEntity>>(salas, HttpStatus.OK);
	}

}
