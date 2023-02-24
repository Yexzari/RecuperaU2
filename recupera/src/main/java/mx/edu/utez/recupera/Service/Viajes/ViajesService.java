package mx.edu.utez.recupera.Service.Viajes;

import mx.edu.utez.recupera.Usuario.Usuario;
import mx.edu.utez.recupera.Usuario.UsuarioRepository;
import mx.edu.utez.recupera.Viajes.Viajes;
import mx.edu.utez.recupera.Viajes.ViajesReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
@Transactional
@Service
public class ViajesService {
    @Autowired
    private ViajesReposity repository_p;


    @Transactional(readOnly = true)
    public ResponseEntity<List<Viajes>> getAll(){
        return new ResponseEntity<>(this.repository_p.findAll(), HttpStatus.OK);
    }
    @Transactional(readOnly = true)
    public ResponseEntity getOne(Long id){
        return new ResponseEntity<Object>(this.repository_p.findById(id), HttpStatus.OK);
    }

    @Transactional
    public Viajes savePoke(Viajes viajes)
    {
        return repository_p.save(viajes);
    }

    @Transactional
    public Viajes
    updatePoke(Viajes viajes,
               Long Id)
    {
        Viajes depDB
                = repository_p.findById(Id)
                .get();



        if (Objects.nonNull(
                viajes.getSalida())
                && !"".equalsIgnoreCase(
                viajes.getSalida())) {
            depDB.setSalida(
                    viajes.getSalida());
        }
        if (Objects.nonNull(
                viajes.getRegreso())
                && !"".equalsIgnoreCase(
                viajes.getRegreso())) {
            depDB.setRegreso(
                    viajes.getRegreso());
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
