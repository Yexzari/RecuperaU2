package mx.edu.utez.recupera.Destino;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "destino")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Destino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false,length = 150)
    private String name;
    @Column(name = "descripcion",nullable = false,length = 150)
    private String descripcion;
    @Column(name = "precio", nullable = false)
    private Double precio;
    @Column(name = "calificacion", nullable = false)
    private Double calificacion;
    @Column(name = "dispo", nullable = false)
    private Boolean dispo;

}
