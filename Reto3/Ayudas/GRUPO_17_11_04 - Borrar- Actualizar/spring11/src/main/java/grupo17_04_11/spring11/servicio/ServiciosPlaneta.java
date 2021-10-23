package grupo17_04_11.spring11.servicio;

import java.util.List;
import grupo17_04_11.spring11.modelo.Planeta;

public interface ServiciosPlaneta {

    public List<Planeta> listarPlanetas();
    public void guardarPlanetas(Planeta planeta);
    public void eliminarPlanetas(Planeta planeta);
    public void eliminarPlanetas(int codigo);


}