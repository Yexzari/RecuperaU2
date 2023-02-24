package mx.edu.utez.recupera.Service.Destino;

import mx.edu.utez.recupera.Destino.Destino;
import mx.edu.utez.recupera.Destino.DestinoReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class DestinoService {
    @Autowired
    private DestinoReposity repository_e;


    @Transactional(readOnly = true)
    public ResponseEntity<List<Destino>> getAll(){
        return new ResponseEntity<>(this.repository_e.findAll(), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity getOne(Long id){
        return new ResponseEntity(this.repository_e.findById(id),HttpStatus.OK);
    }
}
