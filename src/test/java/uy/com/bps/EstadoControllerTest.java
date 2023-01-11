package uy.com.bps;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import uy.com.bps.controller.EstadoController;
import uy.com.bps.model.Estado;
import uy.com.bps.service.EstadoService;

@ExtendWith(MockitoExtension.class)
public class EstadoControllerTest {
	
	@InjectMocks
	EstadoController estadoController;
	
	@Mock
	EstadoService estadoService;
	
	@Test
	public void testEstadoObtenerTodo() {
		Estado objEstado = new Estado();
		Estado objEstado2 = new Estado();
		objEstado.setIdestado(1L);
		objEstado.setDescestado("Activo");
		objEstado2.setIdestado(2L);
		objEstado2.setDescestado("Inactivo");
		List<Estado> estados = new ArrayList<Estado>();
		//estados.add(objEstado);
		//estados.add(objEstado2);
		when(estadoService.obtenerTodo()).thenReturn(estados);
		ResponseEntity<List<Estado>> resultadoEstado = estadoController.obtenerTodo();
		//assertThat(resultadoEstado.getBody().size()).isEqualTo(0);
		assertThat(resultadoEstado.getStatusCodeValue()).isEqualTo(204);
	}
	
	@Test
	public void testCrearEstado() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		when(estadoService.guardar(any(Estado.class))).thenReturn(new Estado());
		Estado estado = new Estado();
		estado.setIdestado(1L);
		estado.setDescestado("Activo");
		ResponseEntity<Estado> resultadoEstado = estadoController.crearEstado(estado);
		assertThat(resultadoEstado.getStatusCodeValue()).isEqualTo(201);
		
		
	}

}
