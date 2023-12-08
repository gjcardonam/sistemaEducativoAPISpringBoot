package sistemaeducativo.sistemaeducativo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "curest")
public class CurEst {

    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idcur", referencedColumnName = "id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "idest", referencedColumnName = "id")
    private Estudiante estudiante;

    public CurEst(Curso curso, Estudiante estudiante) {
        this.curso = curso;
        this.estudiante = estudiante;
    }

    public CurEst() {
    }

    public CurEst(Integer id, Curso curso, Estudiante estudiante) {
        this.id = id;
        this.curso = curso;
        this.estudiante = estudiante;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    
    
}
