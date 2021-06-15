package pe.edu.upc.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Tarjeta")
public class Tarjeta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTarjeta;

	@NotEmpty(message = "Ingrese nombre")
	@Column(name = "nameTarjeta", nullable = false, length = 50)
	private String nameTarjeta;
	
	@NotNull(message = "Ingrese nombre")
	@Past(message = "La fecha de creación debe ser pasada")
	@Temporal(TemporalType.DATE)
	@Column(name = "birthDateTarjeta")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDateTarjeta;

	@NotEmpty(message = "Ingrese numero de tarjeta")
	@Size(min = 16, max = 16)
	@Digits(integer = 16, fraction = 0)
	@Column(name = "numTarjeta", nullable = false, length = 50)
	private String numTarjeta;
	
	@NotEmpty(message = "Ingrese nombre")
	@Column(name = "tipoTarjeta", nullable = false, length = 50)
	private String tipoTarjeta;
	
	public Tarjeta(int idTarjeta, String nameTarjeta, Date birthDateTarjeta, String tipoTarjeta,
			String numTarjeta) {
		super();
		this.idTarjeta = idTarjeta;
		this.nameTarjeta = nameTarjeta;
		this.birthDateTarjeta = birthDateTarjeta;
		this.tipoTarjeta=tipoTarjeta;
		this.numTarjeta = numTarjeta;
	}

	public Tarjeta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public String getNameTarjeta() {
		return nameTarjeta;
	}

	public void setNameTarjeta(String nameTarjeta) {
		this.nameTarjeta = nameTarjeta;
	}

	public Date getBirthDateTarjeta() {
		return birthDateTarjeta;
	}

	public void setBirthDateTarjeta(Date birthDateTarjeta) {
		this.birthDateTarjeta = birthDateTarjeta;
	}


	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}
	public String getTipoTarjeta() {
		return tipoTarjeta;
	}

	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}
}
