package pe.edu.upc.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Membresia")
public class Membresia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMembresia;
	
	
	@ManyToOne
	@JoinColumn(name = "idTipoMembresia", nullable = false)
	private TipoMembrecia tipoMembresia;

	public Membresia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Membresia(int idMembresia, TipoMembrecia tipoMembresia) {
		super();
		this.idMembresia = idMembresia;
		this.tipoMembresia = tipoMembresia;
	}

	public int getIdMembresia() {
		return idMembresia;
	}

	public void setIdMembresia(int idMembresia) {
		this.idMembresia = idMembresia;
	}

	

	public TipoMembrecia getTipoMembresia() {
		return tipoMembresia;
	}

	public void setTipoMembresia(TipoMembrecia tipoMembresia) {
		this.tipoMembresia = tipoMembresia;
	}

}
