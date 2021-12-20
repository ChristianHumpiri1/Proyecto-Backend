package uc.us_security.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="seminario")
public class Seminario implements Serializable{
	
	private static final long serialVersionUID = 5528903670777570350L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idseminario")
	private int idsem;
	@Column(name="nombresem")
	private String nombresem;
	@Column(name="fechainicio")
	private String fechainicio;
	@Column(name="fechafin")
	private String fechafin;

}
