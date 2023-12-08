package sistemaeducativo.sistemaeducativo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sistemaeducativo.sistemaeducativo.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
    
}
