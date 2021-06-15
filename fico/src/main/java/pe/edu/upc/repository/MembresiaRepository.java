package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.Membresia;

@Repository
public interface MembresiaRepository extends JpaRepository<Membresia, Integer> {

}
