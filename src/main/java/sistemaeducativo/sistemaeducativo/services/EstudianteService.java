package sistemaeducativo.sistemaeducativo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import sistemaeducativo.sistemaeducativo.entities.Estudiante;
import sistemaeducativo.sistemaeducativo.interfaces.IEstudianteService;
import sistemaeducativo.sistemaeducativo.repositories.EstudianteRepository;

@Service
public class EstudianteService implements IEstudianteService {

    private EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public List<Estudiante> getEstudiantes() {
        return estudianteRepository.findAll();
    }
    
}
