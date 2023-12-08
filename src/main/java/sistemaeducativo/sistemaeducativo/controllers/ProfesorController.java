package sistemaeducativo.sistemaeducativo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sistemaeducativo.sistemaeducativo.entities.Asignatura;
import sistemaeducativo.sistemaeducativo.entities.Estudiante;
import sistemaeducativo.sistemaeducativo.entities.Profesor;
import sistemaeducativo.sistemaeducativo.interfaces.IProfesorService;

@RestController
@RequestMapping("/profesor")
@CrossOrigin
public class ProfesorController {

    private IProfesorService profesorService;

    public ProfesorController(IProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Profesor> getProfesores() {
        return profesorService.getProfesores();
    }

    @RequestMapping(value = "/{nombre}/asignaturas", method = RequestMethod.GET)
    public List<Asignatura> getAsignaturas(@PathVariable String nombre) {
        Profesor profesor = profesorService.getProfesor(nombre);
        return profesorService.getAsignaturas(profesor);
    }

    @RequestMapping(value = "/asignaturas", method = RequestMethod.GET)
    public Map<String, List<Asignatura>> getProfesoresConAsignaturas() {
        return profesorService.getProfesoresConAsignaturas();
    }

    @RequestMapping(value = "/{nombre}/estudiantes", method = RequestMethod.GET)
    public List<Estudiante> getEstudiantes(@PathVariable String nombre) {
        Profesor profesor = profesorService.getProfesor(nombre);
        return profesorService.getEstudiantes(profesor);
    }

    @RequestMapping(value = "/estudiantes", method = RequestMethod.GET)
    public Map<String, Map<String, List<Estudiante>>> getProfesorConEstudiantes() {
        return profesorService.getProfesorConEstudiantes();
    }

}
