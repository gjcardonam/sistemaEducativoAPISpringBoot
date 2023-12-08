package sistemaeducativo.sistemaeducativo.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import sistemaeducativo.sistemaeducativo.entities.Asignatura;
import sistemaeducativo.sistemaeducativo.entities.CurAsig;
import sistemaeducativo.sistemaeducativo.entities.CurEst;
import sistemaeducativo.sistemaeducativo.entities.Curso;
import sistemaeducativo.sistemaeducativo.entities.Estudiante;
// import sistemaeducativo.sistemaeducativo.entities.Estudiante;
import sistemaeducativo.sistemaeducativo.entities.Profesor;
import sistemaeducativo.sistemaeducativo.interfaces.IProfesorService;
import sistemaeducativo.sistemaeducativo.repositories.AsignaturaRepository;
import sistemaeducativo.sistemaeducativo.repositories.CurAsigRepository;
import sistemaeducativo.sistemaeducativo.repositories.CurEstRepository;
import sistemaeducativo.sistemaeducativo.repositories.CursoRepository;
import sistemaeducativo.sistemaeducativo.repositories.EstudianteRepository;
import sistemaeducativo.sistemaeducativo.repositories.ProfesorRepository;

@Service
public class ProfesorService implements IProfesorService {

    private AsignaturaRepository asignaturaRepository;
    private CurAsigRepository curAsigRepository;
    private CurEstRepository curEstRepository;
    private CursoRepository cursoRepository;
    private EstudianteRepository estudianteRepository;
    private ProfesorRepository profesorRepository;

    public ProfesorService(AsignaturaRepository asignaturaRepository, CurAsigRepository curAsigRepository,
            CurEstRepository curEstRepository, CursoRepository cursoRepository,
            EstudianteRepository estudianteRepository, ProfesorRepository profesorRepository) {
        this.asignaturaRepository = asignaturaRepository;
        this.curAsigRepository = curAsigRepository;
        this.curEstRepository = curEstRepository;
        this.cursoRepository = cursoRepository;
        this.estudianteRepository = estudianteRepository;
        this.profesorRepository = profesorRepository;
    }

    @Override
    public List<Profesor> getProfesores() {
        return this.profesorRepository.findAll();
    }

    @Override
    public List<Asignatura> getAsignaturas(Profesor profesor) {
        return asignaturaRepository.findAll().stream()
                .filter(asignatura -> asignatura.getProfesor().getId() == profesor.getId())
                .collect(Collectors.toList());
    }

    @Override
    public Profesor getProfesor(String nombre) {
        return this.profesorRepository.findByNombre(nombre);
    }

    @Override
    public Map<String, List<Asignatura>> getProfesoresConAsignaturas() {
        return getProfesores().stream()
                .collect(Collectors.toMap(
                        profesor -> profesor.getNombre(),
                        profesor -> getAsignaturas(profesor)));
    }

    @Override
    public List<Estudiante> getEstudiantes(Profesor profesor) {
        List<Asignatura> asignaturas = getAsignaturas(profesor);
        List<CurAsig> curAsigs = curAsigRepository.findAll();
        List<Curso> cursos = cursoRepository.findAll();
        List<CurEst> curEsts = curEstRepository.findAll();

        return estudianteRepository.findAll().stream().filter(estudiante -> {
            return asignaturas.stream().anyMatch(asignatura -> {
                return curAsigs.stream().anyMatch(curAsig -> {
                    if (curAsig.getAsignatura().getId() == asignatura.getId()) {
                        return cursos.stream().anyMatch(curso -> {
                            if (curso.getId() == curAsig.getCurso().getId()) {
                                return curEsts.stream().anyMatch(curEst -> {
                                    if (curEst.getCurso().getId() == curso.getId()) {
                                        return curEst.getEstudiante().getId() == estudiante.getId();
                                    }
                                    return false;
                                });
                            }
                            return false;
                        });
                    }
                    return false;
                });
            });
        }).collect(Collectors.toList());
    }

    public List<Estudiante> getEstudiantesDeAsignatura(Asignatura asignatura) {
        List<CurAsig> curAsigs = curAsigRepository.findAll();
        List<Curso> cursos = cursoRepository.findAll();
        List<CurEst> curEsts = curEstRepository.findAll();
    
        return estudianteRepository.findAll().stream().filter(estudiante -> {
            return curAsigs.stream().anyMatch(curAsig -> {
                if (curAsig.getAsignatura().getId() == asignatura.getId()) {
                    return cursos.stream().anyMatch(curso -> {
                        if (curso.getId() == curAsig.getCurso().getId()) {
                            return curEsts.stream().anyMatch(curEst -> {
                                if (curEst.getCurso().getId() == curso.getId()) {
                                    return curEst.getEstudiante().getId() == estudiante.getId();
                                }
                                return false;
                            });
                        }
                        return false;
                    });
                }
                return false;
            });
        }).collect(Collectors.toList());
    }

    @Override
    public Map<String, Map<String, List<Estudiante>>> getProfesorConEstudiantes() {
        return profesorRepository.findAll().stream().collect(Collectors.toMap(
            profesor -> profesor.getNombre(),
            profesor -> {
                Map<String, List<Estudiante>> asignaturasYEstudiantes = new HashMap<>();
                List<Asignatura> asignaturasDelProfesor = getAsignaturas(profesor);
                for (Asignatura asignatura : asignaturasDelProfesor) {
                    List<Estudiante> estudiantesDeLaAsignatura = getEstudiantesDeAsignatura(asignatura);
                    asignaturasYEstudiantes.put(asignatura.getNombre(), estudiantesDeLaAsignatura);
                }
                return asignaturasYEstudiantes;
            }
        ));
}

}
