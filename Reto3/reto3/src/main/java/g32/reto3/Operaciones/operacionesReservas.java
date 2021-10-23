package g32.reto3.Operaciones;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import g32.reto3.Interfaces.interfaceReservas;
import g32.reto3.Modelo.modeloReservas;

@Repository
public class operacionesReservas {

    @Autowired
    private interfaceReservas crud4;

    public List<modeloReservas> getAll(){
        return (List<modeloReservas>) crud4.findAll();
    }
    public Optional<modeloReservas> getReservation(int id){
        return crud4.findById(id);
    }
    public modeloReservas save(modeloReservas reservation){
        return crud4.save(reservation);
    }
    public void delete(modeloReservas reservation){
        crud4.delete(reservation);
    }
    
}
