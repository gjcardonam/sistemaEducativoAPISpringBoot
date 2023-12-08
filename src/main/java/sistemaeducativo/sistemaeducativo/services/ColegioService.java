package sistemaeducativo.sistemaeducativo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import sistemaeducativo.sistemaeducativo.entities.Colegio;
import sistemaeducativo.sistemaeducativo.interfaces.IColegioService;
import sistemaeducativo.sistemaeducativo.repositories.ColegioRepository;

@Service
public class ColegioService implements IColegioService{

    private ColegioRepository colegioRepository;

    public ColegioService(ColegioRepository colegioRepository) {
        this.colegioRepository = colegioRepository;
    }

    @Override
    public List<Colegio> getColegios() {
        return colegioRepository.findAll();
    }
    
}
