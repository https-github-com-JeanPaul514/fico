package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Membresia;
import pe.edu.upc.repository.MembresiaRepository;
import pe.edu.upc.service.IMembresiaService;

@Service
public class MembresiaServiceImpl implements IMembresiaService {
	@Autowired
	private MembresiaRepository sR;

	@Override
	public void insert(Membresia s) {
		sR.save(s);
	}

	@Override
	public List<Membresia> list() {
		// TODO Auto-generated method stub
		return sR.findAll();
	}

	@Override
	public void delete(int id) {
		sR.deleteById(id);
	}

}
