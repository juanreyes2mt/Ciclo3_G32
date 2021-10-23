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

import g32.reto3.Modelo.modeloBicicleta;
import g32.reto3.Servicios.serviciosBicicleta;

@RestController
@RequestMapping("/api/Bike")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class controladorBicicleta {

    @Autowired
    private serviciosBicicleta servicio;

    @GetMapping("/all")
    public List<modeloBicicleta> getBikes(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<modeloBicicleta> getBike(@PathVariable("id") int bikeId) {
        return servicio.getBike(bikeId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public modeloBicicleta save(@RequestBody modeloBicicleta bike) {
        return servicio.save(bike);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public modeloBicicleta update(@RequestBody modeloBicicleta bike) {
        return servicio.update(bike);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int bikeId) {
        return servicio.deleteBike(bikeId);
    }
    
}
