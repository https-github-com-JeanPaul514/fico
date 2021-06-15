package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Asesoria;

public interface IAsesoriaService {
	public void insert(Asesoria s);

	List<Asesoria> list();

	public void delete(int id);
}
