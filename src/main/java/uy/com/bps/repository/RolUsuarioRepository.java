package uy.com.bps.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import uy.com.bps.model.security.RolUsuario;

@Repository
public interface RolUsuarioRepository extends JpaRepository<RolUsuario, Long> {
	
	//@Query(value = "{call sp_RolxUsuario(:idusuario)}", nativeQuery = true)
	//public List<RolUsuario> listarRolesPorUsuario(@Param("idusuario") int _idusuario);
	@Procedure(procedureName ="sp_RolxUsuario")
	public List<RolUsuario> listarRolesPorUsuario(int _idusuario);
}
