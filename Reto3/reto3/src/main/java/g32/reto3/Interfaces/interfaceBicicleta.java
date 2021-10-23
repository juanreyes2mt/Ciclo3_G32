package g32.reto3.Interfaces;

import org.springframework.data.repository.CrudRepository;
import g32.reto3.Modelo.modeloBicicleta;

public interface interfaceBicicleta extends CrudRepository <modeloBicicleta,Integer> {
    
}