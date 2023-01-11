package uy.com.bps.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface BaseService<E> {
	
	public List<E> obtenerTodo();
	
	public E guardar(E entity);
	
	public Optional<E> obtenerPorId(Long id);
	
	public HashMap<String, String> eliminarPorId(Long id);
	

}
