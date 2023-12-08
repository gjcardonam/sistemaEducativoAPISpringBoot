package sistemaeducativo.sistemaeducativo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sistemaeducativo.sistemaeducativo.entities.Curso;
import sistemaeducativo.sistemaeducativo.interfaces.ICursoService;

@RestController
@RequestMapping("/curso")
@CrossOrigin
public class CursoController {
    
    private ICursoService cursoService;
    
    public CursoController(ICursoService cursoService) {
        this.cursoService = cursoService;
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Curso> getCursos() {
        return cursoService.getCursos();
    }
}
