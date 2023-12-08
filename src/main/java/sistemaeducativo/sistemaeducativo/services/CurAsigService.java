package sistemaeducativo.sistemaeducativo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import sistemaeducativo.sistemaeducativo.entities.CurAsig;
import sistemaeducativo.sistemaeducativo.interfaces.ICurAsigService;
import sistemaeducativo.sistemaeducativo.repositories.CurAsigRepository;

@Service
public class CurAsigService implements ICurAsigService {

    private CurAsigRepository curAsigRepository;

    public CurAsigService(CurAsigRepository curAsigRepository) {
        this.curAsigRepository = curAsigRepository;
    }

    @Override
    public List<CurAsig> getCurAsigs() {
        return curAsigRepository.findAll();
    }
    
}
