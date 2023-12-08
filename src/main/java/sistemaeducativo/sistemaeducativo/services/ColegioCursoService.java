package sistemaeducativo.sistemaeducativo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import sistemaeducativo.sistemaeducativo.entities.ColegioCurso;
import sistemaeducativo.sistemaeducativo.interfaces.IColegioCursoService;
import sistemaeducativo.sistemaeducativo.repositories.ColegioCursoRepository;

@Service
public class ColegioCursoService implements IColegioCursoService{

    private ColegioCursoRepository colegioCursoRepository;

    public ColegioCursoService(ColegioCursoRepository colegioCursoRepository) {
        this.colegioCursoRepository = colegioCursoRepository;
    }

    @Override
    public List<ColegioCurso> getColegioCursos() {
        return colegioCursoRepository.findAll();        
    }
    
}
