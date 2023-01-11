package uy.com.bps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.com.bps.model.security.RolUsuario;
import uy.com.bps.model.security.Usuario;
import uy.com.bps.repository.RolUsuarioRepository;
import uy.com.bps.repository.UsuarioRepository;

@Service
public class SeguridadService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RolUsuarioRepository rolUsuarioRepository;
	
	
	public Optional<Usuario> autenticarusuario(String usuario, String password){
		Optional<Usuario> usuarioEntity = 
				usuarioRepository.autenticarusuario(usuario, password);
		if(usuarioEntity.equals(null)) {
			return Optional.empty();
		}else 
			return usuarioEntity;	
	}
	
	public String[] listarRolesPorUsuario(int idusuario) {
		List<RolUsuario> lista =
				rolUsuarioRepository.listarRolesPorUsuario(idusuario);
		String[] listaRoles = new String[lista.size()];
		for(int i=0; i < lista.size(); i++) {
			listaRoles[i] = lista.get(i).getNomrol();
		}
		return listaRoles;
	}
	

	

}
