package uy.com.bps.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.com.bps.model.sp.Empleado;
import uy.com.bps.repository.EmpleadoRepository;

@Service
public class EmpleadoService {
	
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	public HashMap<String, String>registrarEmpleado(Empleado empleado){
		empleadoRepository.registrarEmpleado(empleado.getNombre(), 
				empleado.getApellido());
		HashMap<String, String> respuesta = new HashMap<String, String>();
		respuesta.put("mensaje", "Empleado registrado correctamente");
		return respuesta;
	}

}
