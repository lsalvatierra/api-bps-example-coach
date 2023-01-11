package uy.com.bps.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uy.com.bps.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {



}
