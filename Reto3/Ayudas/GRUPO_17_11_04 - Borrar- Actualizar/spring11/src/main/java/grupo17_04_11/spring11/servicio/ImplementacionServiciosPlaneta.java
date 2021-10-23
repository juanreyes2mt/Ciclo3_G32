package grupo17_04_11.spring11.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import grupo17_04_11.spring11.modelo.Planeta;
import grupo17_04_11.spring11.repositorio.RepositorioPlaneta;


@Service
public class ImplementacionServiciosPlaneta implements ServiciosPlaneta {

  
    @Autowired
    RepositorioPlaneta repositorioPlaneta;


    @Transactional (readOnly = true)
    @Override
    public List<Planeta> listarPlanetas() {
        return    (List <Planeta>) repositorioPlaneta.findAll();
    }


    @Transactional
    @Override
    public void guardarPlanetas(Planeta planeta) {
        repositorioPlaneta.save(planeta);        
    }

    @Transactional
    @Override
    public void eliminarPlanetas(Planeta planeta) {
            // opcion 1 
            //operacionesPlaneta.deleteById(planeta.getCodigo());        
            // opcion 2
            repositorioPlaneta.delete(planeta);
    }
    
    
    @Transactional
    @Override
    public void eliminarPlanetas(int codigo) {
        repositorioPlaneta.deleteById(codigo);        
    }
}
