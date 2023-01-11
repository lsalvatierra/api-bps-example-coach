package uy.com.bps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.com.bps.model.Sala;
import uy.com.bps.repository.SalaRepository;

@Service
public class SalaService {
	
	@Autowired
	private SalaRepository salaRepository;
	
	public List<Sala> obtenerTodo(){
		return salaRepository.findAll();
	}

}
