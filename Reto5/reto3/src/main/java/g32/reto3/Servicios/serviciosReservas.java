package g32.reto3.Servicios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g32.reto3.Modelo.modeloReservas;
import g32.reto3.Operaciones.contadorClientes;
import g32.reto3.Operaciones.operacionesReservas;
import g32.reto3.Operaciones.statusReservas;

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

    public statusReservas reporteStatusServicio (){
        List<modeloReservas>completed= metodosCrud.ReservacionStatusRepositorio("completed");
        List<modeloReservas>cancelled= metodosCrud.ReservacionStatusRepositorio("cancelled");
        
        return new statusReservas(completed.size(), cancelled.size() );
    }

    public List<modeloReservas> reporteTiempoServicio (String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
        
        Date datoUno = new Date();
        Date datoDos = new Date();
        
        try{
             datoUno = parser.parse(datoA);
             datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return metodosCrud.ReservacionTiempoRepositorio(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        
        } 
    }

    public List<contadorClientes> reporteClientesServicio(){
        return metodosCrud.getClientesRepositorio();
    }

}
