package mx.edu.utez.recupera.Viajes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.recupera.Destino.Destino;
import mx.edu.utez.recupera.Usuario.Usuario;

import javax.persistence.*;
@Entity
@Table(name = "viajes")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Viajes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "destino_id", nullable = false)
    private Destino destino;
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    @Column(name = "salida",nullable = false, unique = true, length = 150)
    private String salida;
    @Column(name = "regreso", nullable = false, length = 150)
    private String regreso;
}
