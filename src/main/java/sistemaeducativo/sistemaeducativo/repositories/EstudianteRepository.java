package sistemaeducativo.sistemaeducativo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sistemaeducativo.sistemaeducativo.entities.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer>{
    
}
