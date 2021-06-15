package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Asesor;
import pe.edu.upc.repository.AsesorRepository;
import pe.edu.upc.service.IAsesorService;

@Service
public class AsesorServiceImpl implements IAsesorService {

	@Autowired
	private AsesorRepository mR;

	@Override
	public void insert(Asesor mc) {

		mR.save(mc);

	}

	@Override
	public List<Asesor> list() {
		// TODO Auto-generated method stub
		return mR.findAll();
	}

	@Override
	public void delete(int id) {
		mR.deleteById(id);
	}

}
