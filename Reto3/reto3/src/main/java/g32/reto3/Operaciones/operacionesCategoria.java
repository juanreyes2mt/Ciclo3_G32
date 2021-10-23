package g32.reto3.Operaciones;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import g32.reto3.Interfaces.interfaceCategoria;
import g32.reto3.Modelo.modeloCategoria;

@Repository
public class operacionesCategoria {

    @Autowired
    private interfaceCategoria crud;
    
    public List<modeloCategoria> getAll(){
        return (List<modeloCategoria>) crud.findAll();
    }
    public Optional<modeloCategoria> getCategoria(int id){
        return crud.findById(id);
    }

    public modeloCategoria save(modeloCategoria Categoria){
        return crud.save(Categoria);
    }
    public void delete(modeloCategoria Categoria){
       crud.delete(Categoria);
    }
    
}
