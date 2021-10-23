package g32.reto3.Operaciones;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import g32.reto3.Interfaces.interfaceBicicleta;
import g32.reto3.Modelo.modeloBicicleta;

@Repository
public class operacionesBicicleta {

    @Autowired
    private interfaceBicicleta crud;

    public List<modeloBicicleta> getAll(){
        return (List<modeloBicicleta>) crud.findAll();
    }

    public Optional<modeloBicicleta> getBike(int id){
        return crud.findById(id);
    }

    public modeloBicicleta save(modeloBicicleta bike){
        return crud.save(bike);
    }
    public void delete(modeloBicicleta bike){
        crud.delete(bike);
    }
    
}
