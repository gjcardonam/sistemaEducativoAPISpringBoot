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
@Table(name = "curso")
public class Curso {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_id")
    @GenericGenerator(name = "secuencia_id", strategy = "increment")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    @Column(name = "grado", length = 50)
    private Integer grado;

    @Column(name = "salon", length = 50)
    private String salon;

    public Curso(Integer grado, String salon) {
        this.grado = grado;
        this.salon = salon;
    }

    public Curso() {
    }

    public Curso(Integer id, Integer grado, String salon) {
        this.id = id;
        this.grado = grado;
        this.salon = salon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrado() {
        return grado;
    }

    public void setGrado(Integer grado) {
        this.grado = grado;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    
}
