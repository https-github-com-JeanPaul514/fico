package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Cliente;
import pe.edu.upc.repository.ClienteRepository;
import pe.edu.upc.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {
	@Autowired
	private ClienteRepository sR;

	@Override
	public void insert(Cliente s) {
		sR.save(s);
	}

	@Override
	public List<Cliente> list() {
		// TODO Auto-generated method stub
		return sR.findAll();
	}

	@Override
	public void delete(int id) {
		sR.deleteById(id);
	}

}
