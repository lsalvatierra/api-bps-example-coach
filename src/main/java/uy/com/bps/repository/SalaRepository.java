package uy.com.bps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uy.com.bps.model.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long>{

}
