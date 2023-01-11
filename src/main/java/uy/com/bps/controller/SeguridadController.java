package uy.com.bps.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import uy.com.bps.exception.ResourceNotFoundException;
import uy.com.bps.model.security.Usuario;
import uy.com.bps.model.security.UsuarioResponse;
import uy.com.bps.service.SeguridadService;



@RestController
@RequestMapping("api/v1/seguridad")
public class SeguridadController {

	@Autowired
	private SeguridadService seguridadService;
	
	@PostMapping("/autenticacion")
	@Transactional(readOnly = true)
	public ResponseEntity<UsuarioResponse> autenticarUsuario(
			@RequestParam("usuario")String usuario,
			@RequestParam("password")String password){
		Usuario objUsuario = seguridadService
				.autenticarusuario(usuario, password)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario o password incorrecto"));
		if(objUsuario != null) {
			String token = generarToken(usuario, Integer.parseInt(objUsuario.getIdusuario().toString()));
			UsuarioResponse usuarioResponse = 
					new UsuarioResponse(objUsuario.getIdusuario(), 
							objUsuario.getNomusuario(), token);
			return new ResponseEntity<UsuarioResponse>(usuarioResponse, HttpStatus.OK);	
		}
		return null;
	}
	
	
	
	private String generarToken(String usuario, int idusuario) {
		String claveSecreta = "${security.clave}";
		List<GrantedAuthority> listAutorizacion = 
				AuthorityUtils.createAuthorityList(
						seguridadService.listarRolesPorUsuario(idusuario));
		String token = Jwts
				.builder()
				.setId("@bpsjwt")
				.setSubject(usuario)
				.claim("authorities", listAutorizacion.stream()
						.map(GrantedAuthority::getAuthority)
						.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+300000))
				.signWith(SignatureAlgorithm.HS512, claveSecreta.getBytes())
				.compact();
		return "Bearer "+token;
	}
}
