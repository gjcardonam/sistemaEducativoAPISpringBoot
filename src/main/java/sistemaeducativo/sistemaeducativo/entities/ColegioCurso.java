package sistemaeducativo.sistemaeducativo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "colegiocurso")
public class ColegioCurso {

    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idcol", referencedColumnName = "id")
    private Colegio colegio;

    @ManyToOne
    @JoinColumn(name = "idcur", referencedColumnName = "id")
    private Curso curso;

    public ColegioCurso(Colegio colegio, Curso curso) {
        this.colegio = colegio;
        this.curso = curso;
    }

    public ColegioCurso() {
    }

    public ColegioCurso(Integer id, Colegio colegio, Curso curso) {
        this.id = id;
        this.colegio = colegio;
        this.curso = curso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Colegio getColegio() {
        return colegio;
    }

    public void setColegio(Colegio colegio) {
        this.colegio = colegio;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    

}