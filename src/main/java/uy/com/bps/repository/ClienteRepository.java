package uy.com.bps.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import uy.com.bps.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	List<Cliente> findByNomclienteContainingAndApeclienteContaining(String nomcliente, 
			String apecliente);
	
	@Query(value = "SELECT c FROM Cliente c WHERE c.nomcliente LIKE %:nomcliente% AND c.apecliente LIKE %:apecliente%")
	List<Cliente> filtroClientexDatos(@Param("nomcliente")String nomcliente, 
			@Param("apecliente") String apellido);
	
	
	
	@Query(value = "SELECT * FROM cliente WHERE cliente.nomcliente LIKE %:nomcliente%",
			nativeQuery = true,
			countQuery = "SELECT count(*) FROM cliente where cliente.nomcliente LIKE %:nomcliente%")
	Page<Cliente> paginacionClientesxNombre(@Param("nomcliente") String nomcliente,
			Pageable pageable);
	
	
}
