package grupo17_04_11.spring11.repositorio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import grupo17_04_11.spring11.modelo.Planeta;

@Repository
public interface RepositorioPlaneta extends CrudRepository<Planeta,Integer> {

}