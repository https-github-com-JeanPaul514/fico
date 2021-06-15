package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Asesor;


@Repository
public interface AsesorRepository extends JpaRepository<Asesor, Integer>{

}
