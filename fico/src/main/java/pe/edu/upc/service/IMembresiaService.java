package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Membresia;

public interface IMembresiaService {
	public void insert(Membresia s);

	List<Membresia> list();

	public void delete(int id);
}
