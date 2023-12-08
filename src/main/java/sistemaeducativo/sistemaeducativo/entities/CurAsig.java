package sistemaeducativo.sistemaeducativo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "curasig")
public class CurAsig {

    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idcur", referencedColumnName = "id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "idasig", referencedColumnName = "id")
    private Asignatura asignatura;

    public CurAsig(Curso curso, Asignatura asignatura) {
        this.curso = curso;
        this.asignatura = asignatura;
    }

    public CurAsig() {
    }

    public CurAsig(Integer id, Curso curso, Asignatura asignatura) {
        this.id = id;
        this.curso = curso;
        this.asignatura = asignatura;
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

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    
}
