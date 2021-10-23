package g32.reto3.Operaciones;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import g32.reto3.Interfaces.interfaceCliente;
import g32.reto3.Modelo.modeloCliente;


@Repository
public class operacionesCliente {

    @Autowired
    private interfaceCliente crud1;

    public List<modeloCliente> getAll(){
        return (List<modeloCliente>) crud1.findAll();
    }
    public Optional<modeloCliente> getCliente(int id){
        return crud1.findById(id);
    }

    public modeloCliente save(modeloCliente cliente){
        return crud1.save(cliente);
    }
    public void delete(modeloCliente cliente){
        crud1.delete(cliente);
    }
    
}
