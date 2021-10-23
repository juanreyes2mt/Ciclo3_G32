package g32.reto3.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g32.reto3.Modelo.modeloReservas;
import g32.reto3.Operaciones.operacionesReservas;

@Service
public class serviciosReservas {

    @Autowired
    private operacionesReservas metodosCrud;

    public List<modeloReservas> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<modeloReservas> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }

    public modeloReservas save(modeloReservas reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<modeloReservas> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    public modeloReservas update(modeloReservas reservation){
        if(reservation.getIdReservation()!=null){
            Optional<modeloReservas> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
