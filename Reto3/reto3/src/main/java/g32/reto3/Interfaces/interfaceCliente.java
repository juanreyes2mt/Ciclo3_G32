package g32.reto3.Interfaces;

import org.springframework.data.repository.CrudRepository;
import g32.reto3.Modelo.modeloCliente;


public interface interfaceCliente extends CrudRepository <modeloCliente,Integer> {
    
}