package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.TipoMembrecia;


@Repository
public interface TipoMembreciaRepository extends JpaRepository<TipoMembrecia, Integer>{

}
