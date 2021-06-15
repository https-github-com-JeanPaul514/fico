package pe.edu.upc.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Asesoria")
public class Asesoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAsesoria;
	@NotEmpty(message = "Ingrese nombre")
	@Column(name = "estadoAsesoria", nullable = false, length = 50)
	private String estadoAsesoria;
	
	@NotNull(message = "Ingrese nombre")
	@Past(message = "La fecha de creación debe ser pasada")
	@Temporal(TemporalType.DATE)
	@Column(name = "birthDateAsesoria")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDateAsesoria;
	
	
	
	@NotEmpty(message = "Ingrese numero de tarjeta")
	@Size(min = 5, max = 5)
	@Digits(integer = 1, fraction = 0)
	@Column(name = "calificacionAsesoria", nullable = false, length = 50)
	private String calificacionAsesoria;
	
	@ManyToOne
	@JoinColumn(name = "idAsesor", nullable = false)
	private Asesor asesor;

	public Asesoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Asesoria(int idAsesoria, Date birthDateAsesoria,String calificacionAsesoria, String estadoAsesoria, Asesor asesor) {
		super();
		this.idAsesoria = idAsesoria;
		this.birthDateAsesoria=birthDateAsesoria;
		this.estadoAsesoria = estadoAsesoria;
		this.calificacionAsesoria = calificacionAsesoria;
		this.asesor = asesor;
	}

	public int getIdAsesoria() {
		return idAsesoria;
	}

	public void setIdAsesoria(int idAsesoria) {
		this.idAsesoria = idAsesoria;
	}

	public Date getBirthDateAsesoria() {
		return birthDateAsesoria;
	}

	public void setBirthDateAsesoria(Date birthDateAsesoria) {
		this.birthDateAsesoria = birthDateAsesoria;
	}
	
	public String getEstadoAsesoria() {
		return estadoAsesoria;
	}

	public void setEstadoAsesoria(String estadoAsesoria) {
		this.estadoAsesoria = estadoAsesoria;
	}
	public String getCalificacionAsesoria() {
		return calificacionAsesoria;
	}

	public void setCalificacionAsesoria(String calificacionAsesoria) {
		this.calificacionAsesoria = calificacionAsesoria;
	}
	public Asesor getAsesor() {
		return asesor;
	}

	public void setAsesor(Asesor asesor) {
		this.asesor = asesor;
	}

}
