package uy.com.bps.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import uy.com.bps.model.Cliente;
import uy.com.bps.repository.ClienteRepository;
import uy.com.bps.utilitarios.UtilConvertBase;
import uy.com.bps.utilitarios.UtilDocumentos;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ClienteService implements BaseService<Cliente> {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	private final Path rutaFolder = Paths.get("documents");
	
	public List<Cliente> obtenerxNombre(String nomcliente, String apecliente){
		return clienteRepository.filtroClientexDatos(nomcliente, apecliente);
	}
	
	public Page<Cliente> paginacionClientexNombre(String nomcliente, Pageable pageable){
		return clienteRepository.paginacionClientesxNombre(nomcliente, pageable);
	}
	

	@Override
	public List<Cliente> obtenerTodo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente guardar(Cliente entity) {
		// TODO Auto-generated method stub
		OutputStream out;
		try {
			out = new FileOutputStream(rutaFolder.resolve(new 
					UtilDocumentos().obtenerNombreDocumento("image/jpeg")).toString());
			out.write(new UtilConvertBase().decodeBase64(entity.getImg()));
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return clienteRepository.save(entity);
	}

	@Override
	public Optional<Cliente> obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, String> eliminarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
