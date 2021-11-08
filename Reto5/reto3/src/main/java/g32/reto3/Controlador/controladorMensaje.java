package g32.reto3.Controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import g32.reto3.Modelo.modeloMensaje;
import g32.reto3.Servicios.serviciosMensaje;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class controladorMensaje {

    @Autowired
    private serviciosMensaje servicio;
    @GetMapping("/all")
    public List<modeloMensaje> getMessages(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<modeloMensaje> getMessage(@PathVariable("id") int messageId) {
        return servicio.getMessage(messageId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public modeloMensaje save(@RequestBody modeloMensaje message) {
        return servicio.save(message);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public modeloMensaje update(@RequestBody modeloMensaje message) {
        return servicio.update(message);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int messageId) {
        return servicio.deleteMessage(messageId);
    }
    
}
