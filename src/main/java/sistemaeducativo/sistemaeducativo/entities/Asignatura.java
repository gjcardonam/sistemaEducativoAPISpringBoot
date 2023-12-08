package sistemaeducativo.sistemaeducativo.entities;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "asignatura")
public class Asignatura {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_id")
    @GenericGenerator(name = "secuencia_id", strategy = "increment")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idprof", referencedColumnName = "id")
    private Profesor profesor;

    public Asignatura(String nombre, Profesor profesor) {
        this.nombre = nombre;
        this.profesor = profesor;
    }
    
    public Asignatura(String nombre) {
        this.nombre = nombre;
    }

    public Asignatura() {
    }

    public Asignatura(Integer id, String nombre, Profesor profesor) {
        this.id = id;
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    
}
