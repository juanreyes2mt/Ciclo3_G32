package g32.reto3.Operaciones;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import g32.reto3.Interfaces.interfaceMensaje;
import g32.reto3.Modelo.modeloMensaje;

@Repository
public class operacionesMensaje {

    @Autowired
    private interfaceMensaje crud3;
    
    public List<modeloMensaje> getAll(){
        return (List<modeloMensaje>) crud3.findAll();
    }
    public Optional<modeloMensaje> getMessage(int id){
        return crud3.findById(id);
    }

    public modeloMensaje save(modeloMensaje message){
        return crud3.save(message);
    }
    public void delete(modeloMensaje message){
        crud3.delete(message);
    }
    
}
