package uy.com.bps.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import uy.com.bps.model.security.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	//@Query(value ="{call sp_AutenticarUsuario(:usuario, :password)}", nativeQuery = true)
	//public Optional<Usuario> autenticarusuario(@Param("usuario") String _usuario, @Param("usuario")String _password);
	@Procedure(procedureName ="sp_autenticarusuario")
	public Optional<Usuario> autenticarusuario(String _usuario, String _password);
}
