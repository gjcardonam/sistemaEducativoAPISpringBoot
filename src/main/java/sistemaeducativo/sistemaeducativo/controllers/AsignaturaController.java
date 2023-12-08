package sistemaeducativo.sistemaeducativo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sistemaeducativo.sistemaeducativo.entities.Asignatura;
import sistemaeducativo.sistemaeducativo.interfaces.IAsignaturaService;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/asignatura")
@CrossOrigin
public class AsignaturaController {
    
    private IAsignaturaService asignaturaService;

    public AsignaturaController(IAsignaturaService asignaturaService) {
        this.asignaturaService = asignaturaService;
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Asignatura> geAsignaturas() {
        return asignaturaService.getAsignaturas();
    }
    
}
