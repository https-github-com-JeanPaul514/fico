package pe.edu.upc.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;



@Entity
@Table(name = "TipoMembresia")
public class TipoMembrecia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoMembresia;

	@NotEmpty(message = "Ingrese nombre")
	@Column(name = "nameTipoMembresia", nullable = false, length = 50)
	private String nameTipoMembresia;



	public TipoMembrecia(int idTipoMembresia, String nameTipoMembresia) {
		super();
		this.idTipoMembresia = idTipoMembresia;
		this.nameTipoMembresia = nameTipoMembresia;
	}

	public TipoMembrecia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdTipoMembresia() {
		return idTipoMembresia;
	}

	public void setIdTipoMembresia(int idTipoMembresia) {
		this.idTipoMembresia = idTipoMembresia;
	}

	public String getNameTipoMembresia() {
		return nameTipoMembresia;
	}

	public void setNameTipoMembresia(String nameTipoMembresia) {
		this.nameTipoMembresia = nameTipoMembresia;
	}

	
}
