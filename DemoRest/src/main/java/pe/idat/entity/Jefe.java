package pe.idat.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="jefes")
public class Jefe implements Serializable
{
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer jefeId;
	
	@Column
	private String nombre_ap;
	
	@Column(unique=true,nullable=false)
	private String celular;
	
	@Column(unique=true,nullable=false)
	private String email;
	
	@OneToOne(mappedBy="jefe")
	private Categoria categoria;
	
	public Jefe() {		
	}

	public Jefe(Integer jefeId, String nombre_ap, String celular, String email) {
		this.jefeId = jefeId;
		this.nombre_ap = nombre_ap;
		this.celular = celular;
		this.email = email;
	}

	public Integer getJefeId() {
		return jefeId;
	}

	public void setJefeId(Integer jefeId) {
		this.jefeId = jefeId;
	}

	public String getNombre_ap() {
		return nombre_ap;
	}

	public void setNombre_ap(String nombre_ap) {
		this.nombre_ap = nombre_ap;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
