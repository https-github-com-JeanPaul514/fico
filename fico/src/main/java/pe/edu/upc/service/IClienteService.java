package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.Cliente;


public interface IClienteService {
	public void insert(Cliente mc);

	List<Cliente> list();

	public void delete(int id);
}
