package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.TipoMembrecia;
import pe.edu.upc.repository.TipoMembreciaRepository;
import pe.edu.upc.service.ITipoMembreciaService;

@Service
public class TipoMembreciaServiceImpl implements ITipoMembreciaService {

	@Autowired
	private TipoMembreciaRepository mR;

	@Override
	public void insert(TipoMembrecia mc) {

		mR.save(mc);

	}

	@Override
	public List<TipoMembrecia> list() {
		// TODO Auto-generated method stub
		return mR.findAll();
	}

	@Override
	public void delete(int id) {
		mR.deleteById(id);
	}

}
