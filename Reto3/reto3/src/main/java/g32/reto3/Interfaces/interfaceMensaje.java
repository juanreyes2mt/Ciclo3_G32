package g32.reto3.Interfaces;

import org.springframework.data.repository.CrudRepository;
import g32.reto3.Modelo.modeloMensaje;


public interface interfaceMensaje extends CrudRepository <modeloMensaje,Integer> {
    
}