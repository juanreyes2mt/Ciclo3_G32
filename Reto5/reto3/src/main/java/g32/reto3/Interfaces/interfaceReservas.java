package g32.reto3.Interfaces;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import g32.reto3.Modelo.modeloReservas;


public interface interfaceReservas extends CrudRepository <modeloReservas,Integer> {
    public List<modeloReservas> findAllByStatus (String status); 
    
    public List<modeloReservas> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    
    // SELECT clientid, COUNT(*) AS total FROM reservacion group by clientid order by desc;
    @Query ("SELECT c.client, COUNT(c.client) from modeloReservas AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationsByClient();

}