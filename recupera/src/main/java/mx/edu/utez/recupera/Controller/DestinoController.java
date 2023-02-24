package mx.edu.utez.recupera.Controller;

import mx.edu.utez.recupera.Destino.Destino;
import mx.edu.utez.recupera.Service.Destino.DestinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/api-aeropuerto/destino")
@CrossOrigin(origins = {"*"})
public class DestinoController {
    @Autowired
    private DestinoService service;


    @GetMapping("/")
    public ResponseEntity<List<Destino>> getAll(){
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable("id") Long id){
        return this.service.getOne(id);
    }
}
