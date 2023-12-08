package sistemaeducativo.sistemaeducativo.entities;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "profesor")
public class Profesor {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_id")
    @GenericGenerator(name = "secuencia_id", strategy = "increment")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;
    
    @Column(name = "nombre", length = 50)
    private String nombre;

    public Profesor(String nombre) {
        this.nombre = nombre;
    }

    public Profesor() {
    }

    public Profesor(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

}
