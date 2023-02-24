package mx.edu.utez.recupera.Controller;

import mx.edu.utez.recupera.Service.Usuario.UsuarioService;
import mx.edu.utez.recupera.Usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/api-aeropuerto/usuarios")
@CrossOrigin(origins = {"*"})
public class UsuariosController {
    @Autowired
    private UsuarioService service;


    @GetMapping("/")
    public ResponseEntity<List<Usuario>> getAll(){
        return this.service.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable("id") Long id){
        return this.service.getOne(id);
    }

    @PostMapping("/")
    public Usuario savePoke(
            @Valid @RequestBody Usuario usuario)
    {
        return service.savePoke(usuario);
    }
    @PutMapping("/{id}")
    public Usuario
    update(@RequestBody Usuario usuario,
           @PathVariable("id") Long Id)
    {
        return service.updatePoke(
                usuario, Id);
    }

    // Delete operation
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id")
                             Long Id)
    {
        service.deleteById(
                Id);
        return "Deleted Successfully";
    }
}
