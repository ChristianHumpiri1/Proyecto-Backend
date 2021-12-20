package uc.us_security.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="sesiones")
public class Sesiones implements Serializable{
	
	private static final long serialVersionUID = 5528903670777570350L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idsesion")
	private int idse;
	@Column(name="nombrese")
	private String nombrese;
	@Column(name="pregunta")
	private String pregunta;
	@Column(name="valoracion")
	private int valora;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idmodulo" )
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Modulo modulo;
	
//	@JsonIgnore
	@OneToMany(mappedBy = "sesiones",cascade =CascadeType.ALL,orphanRemoval = true)
	private List<Recursos> recursos;
}
