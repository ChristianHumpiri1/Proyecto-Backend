package uc.us_security.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="recursos")
public class Recursos implements Serializable{
	
	private static final long serialVersionUID = 5528903670777570350L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idrecursos")
	private int idre;
	@Column(name="nombrere")
	private String nombrere;
	@Column(name="tiporecurso")
	private String recurso;
	@Column(name="estadorecurso")
	private String estado;
	
//	@ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne()
	@JoinColumn(name = "idsesion")
//	  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Sesiones sesiones;
}
