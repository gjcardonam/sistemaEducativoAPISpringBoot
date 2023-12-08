package sistemaeducativo.sistemaeducativo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sistemaeducativo.sistemaeducativo.entities.Asignatura;
import sistemaeducativo.sistemaeducativo.entities.Profesor;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer>{

    List<Asignatura> findAllByProfesor(Profesor profesor);
    
}
