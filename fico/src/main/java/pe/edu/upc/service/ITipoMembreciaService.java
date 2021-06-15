package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.TipoMembrecia;

public interface ITipoMembreciaService {
	public void insert(TipoMembrecia mc);

	List<TipoMembrecia> list();

	public void delete(int id);
}
