package uy.com.bps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "curso")
public class Curso {
	
	@Id
	private String idcurso;
	
	@Column(name = "nomcurso")
	private String nomcurso;
	
	@Column(name = "credito")
	private Integer credito;
	
	

}
