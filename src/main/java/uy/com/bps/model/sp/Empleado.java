package uy.com.bps.model.sp;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {
	
	@Id
	private Long idempleado;
	
	private String nombre;
	private String apellido;
	public Empleado(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	
	

}
