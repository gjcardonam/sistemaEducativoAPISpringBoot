package sistemaeducativo.sistemaeducativo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sistemaeducativo.sistemaeducativo.entities.Estudiante;
import sistemaeducativo.sistemaeducativo.interfaces.IEstudianteService;

@RestController
@RequestMapping("/estudiante")
@CrossOrigin
public class EstudianteController {
    
    private IEstudianteService estudianteService;

    public EstudianteController(IEstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Estudiante> getEstudiantes() {
        return estudianteService.getEstudiantes();
    }
}
