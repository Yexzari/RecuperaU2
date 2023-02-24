package mx.edu.utez.recupera.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name",nullable = false, unique = true, length = 150)
    private String name;
    @Column(name = "correo", nullable = false, length = 150)
    private String correo;
    @Column(name = "fecha", nullable = false)
    private String fecha;
}
