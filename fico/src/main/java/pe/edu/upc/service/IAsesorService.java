package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Asesor;

public interface IAsesorService {
	public void insert(Asesor mc);

	List<Asesor> list();

	public void delete(int id);
}
