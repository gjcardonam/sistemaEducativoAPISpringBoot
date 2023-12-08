package sistemaeducativo.sistemaeducativo.interfaces;

import java.util.List;
import java.util.Map;

import sistemaeducativo.sistemaeducativo.entities.Asignatura;
import sistemaeducativo.sistemaeducativo.entities.Estudiante;
import sistemaeducativo.sistemaeducativo.entities.Profesor;

public interface IProfesorService {
    
    public List<Profesor> getProfesores();
    public Profesor getProfesor(String nombre);
    public List<Asignatura> getAsignaturas(Profesor profesor);
    public Map<String, List<Asignatura>> getProfesoresConAsignaturas();
    public List<Estudiante> getEstudiantes(Profesor profesor);
    public Map<String, Map<String, List<Estudiante>>> getProfesorConEstudiantes();

}
