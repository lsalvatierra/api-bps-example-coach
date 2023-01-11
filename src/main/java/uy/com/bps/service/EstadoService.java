package uy.com.bps.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.com.bps.model.Estado;
import uy.com.bps.repository.EstadoRepository;

@Service
public class EstadoService implements BaseService<Estado> {
	
	@Autowired
	private EstadoRepository estadoRepository;

	@Override
	public List<Estado> obtenerTodo() {
		return estadoRepository.findAll();
	}


	@Override
	public Estado guardar(Estado entity) {	
		return estadoRepository.save(entity);
	}

	@Override
	public Optional<Estado> obtenerPorId(Long id) {
		Optional<Estado> objEstado = estadoRepository.findById(id);
		if(objEstado.equals(null)) {
			return Optional.empty();
		}else {
			return objEstado;
		}
	}

	@Override
	public HashMap<String, String> eliminarPorId(Long id) {
		HashMap<String, String> respuesta = new HashMap<String, String>();
		estadoRepository.deleteById(id);
		respuesta.put("mensaje", "Elemento eliminado correctamente");
		return respuesta;
	}
	
	
	
}
