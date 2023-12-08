package sistemaeducativo.sistemaeducativo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import sistemaeducativo.sistemaeducativo.entities.CurEst;
import sistemaeducativo.sistemaeducativo.interfaces.ICurEstService;
import sistemaeducativo.sistemaeducativo.repositories.CurEstRepository;

@Service
public class CurEstService implements ICurEstService{

    private CurEstRepository curEstRepository;

    public CurEstService(CurEstRepository curEstRepository) {
        this.curEstRepository = curEstRepository;
    }

    @Override
    public List<CurEst> getCurEsts() {
        return curEstRepository.findAll();
    }
    
}
