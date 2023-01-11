package uy.com.bps.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import uy.com.bps.model.sp.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

	@Transactional
	@Modifying
	@Procedure(procedureName = "sp_RegistrarEmpleado")
	int registrarEmpleado(String _nombre, String _apellido);
	
	
	
}
