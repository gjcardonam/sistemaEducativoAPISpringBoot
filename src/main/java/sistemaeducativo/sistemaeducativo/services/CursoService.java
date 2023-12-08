package sistemaeducativo.sistemaeducativo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import sistemaeducativo.sistemaeducativo.entities.Curso;
import sistemaeducativo.sistemaeducativo.interfaces.ICursoService;
import sistemaeducativo.sistemaeducativo.repositories.CursoRepository;

@Service
public class CursoService implements ICursoService{

    private CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public List<Curso> getCursos() {
        return cursoRepository.findAll();
    }

    
    
}
