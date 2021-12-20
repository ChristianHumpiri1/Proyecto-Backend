package uc.us_security.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="modulo")
public class Modulo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5528903670777570350L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idmodulo")
	private int idmo;
	@Column(name="nombremodulo")
	private String nombremo;
	@Column(name="tiposervicio")
	private String tiposervi;
	@Column(name= "recursostotales ")
	private String nu_recursos_totales;
	@JsonIgnore
	@OneToMany(mappedBy = "modulo",cascade =CascadeType.ALL,orphanRemoval = true)
	private List<Sesiones> sesiones;
}
