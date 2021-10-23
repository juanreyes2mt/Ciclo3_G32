package grupo17_04_11.spring11.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import grupo17_04_11.spring11.modelo.Planeta;
import grupo17_04_11.spring11.operaciones.OperacionesPlaneta;

@Service
public class ImplementacionServiciosPlaneta implements ServiciosPlaneta {

    @Autowired
    OperacionesPlaneta operacionesPlaneta;

    @Transactional (readOnly = true)
    @Override
    public List<Planeta> listarPlanetas() {
        return    (List <Planeta>) operacionesPlaneta.findAll();
    }

    @Transactional
    @Override
    public void guardar(Planeta planeta) {

        operacionesPlaneta.save(planeta);

    }



}
