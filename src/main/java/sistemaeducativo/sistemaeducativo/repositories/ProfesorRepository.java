package sistemaeducativo.sistemaeducativo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sistemaeducativo.sistemaeducativo.entities.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer>{
    Profesor findByNombre(String nombre);
}
