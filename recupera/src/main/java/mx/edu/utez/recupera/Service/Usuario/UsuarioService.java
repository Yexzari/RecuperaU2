package mx.edu.utez.recupera.Service.Usuario;

import mx.edu.utez.recupera.Usuario.Usuario;
import mx.edu.utez.recupera.Usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
@Transactional
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository_p;


    @Transactional(readOnly = true)
    public ResponseEntity<List<Usuario>> getAll(){
        return new ResponseEntity<>(this.repository_p.findAll(), HttpStatus.OK);
    }
    @Transactional(readOnly = true)
    public ResponseEntity getOne(Long id){
        return new ResponseEntity<Object>(this.repository_p.findById(id), HttpStatus.OK);
    }

    @Transactional
    public Usuario savePoke(Usuario usuario)
    {
        return repository_p.save(usuario);
    }

    @Transactional
    public Usuario
    updatePoke(Usuario usuario,
               Long Id)
    {
        Usuario depDB
                = repository_p.findById(Id)
                .get();

        if (Objects.nonNull(
                usuario.getName())
                && !"".equalsIgnoreCase(
                usuario.getName())) {
            depDB.setName(
                    usuario.getName());
        }

        if (Objects.nonNull(
                usuario.getCorreo())
                && !"".equalsIgnoreCase(
                usuario.getCorreo())) {
            depDB.setCorreo(
                    usuario.getCorreo());
        }
        if (Objects.nonNull(
                usuario.getFecha())
                && !"".equalsIgnoreCase(
                usuario.getFecha())) {
            depDB.setFecha(
                    usuario.getFecha());
        }




        return repository_p.save(depDB);
    }

    // Delete operation
    @Transactional
    public void deleteById(Long Id)
    {
        repository_p.deleteById(Id);
    }
}
