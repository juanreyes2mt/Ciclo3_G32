package g32.reto3.Operaciones;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import g32.reto3.Interfaces.interfaceReservas;
import g32.reto3.Modelo.modeloReservas;
import g32.reto3.Modelo.modeloCliente;

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
    
    public List<modeloReservas> ReservacionStatusRepositorio (String status){
        return crud4.findAllByStatus(status);
    }
    
    public List<modeloReservas> ReservacionTiempoRepositorio (Date a, Date b){
        return crud4.findAllByStartDateAfterAndStartDateBefore(a, b);
    
    }
    
    public List<contadorClientes> getClientesRepositorio(){
        List<contadorClientes> res = new ArrayList<>();
        List<Object[]> report = crud4.countTotalReservationsByClient();
        for(int i=0; i<report.size(); i++){
            res.add(new contadorClientes((Long)report.get(i)[1],(modeloCliente) report.get(i)[0]));
        }
        return res;
    }

}
