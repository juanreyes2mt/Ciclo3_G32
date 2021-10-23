package grupo17_04_11.spring11.operaciones;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import grupo17_04_11.spring11.modelo.Planeta;

@Repository
public interface OperacionesPlaneta extends CrudRepository<Planeta,Integer> {


}