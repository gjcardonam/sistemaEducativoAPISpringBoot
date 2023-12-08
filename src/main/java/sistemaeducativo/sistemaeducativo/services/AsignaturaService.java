package sistemaeducativo.sistemaeducativo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import sistemaeducativo.sistemaeducativo.entities.Asignatura;
import sistemaeducativo.sistemaeducativo.interfaces.IAsignaturaService;
import sistemaeducativo.sistemaeducativo.repositories.AsignaturaRepository;

@Service
public class AsignaturaService implements IAsignaturaService{

    private AsignaturaRepository asignaturaRepository;

    public AsignaturaService(AsignaturaRepository asignaturaRepository) {
        this.asignaturaRepository = asignaturaRepository;
    }
    
    @Override
    public List<Asignatura> getAsignaturas() {
        return asignaturaRepository.findAll();
    }
    
}
