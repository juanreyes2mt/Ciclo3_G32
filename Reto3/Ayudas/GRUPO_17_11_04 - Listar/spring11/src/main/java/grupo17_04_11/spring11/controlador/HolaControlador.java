package grupo17_04_11.spring11.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import grupo17_04_11.spring11.modelo.Planeta;
import grupo17_04_11.spring11.servicio.ImplementacionServiciosPlaneta;
import java.util.List;


//OPERACIONES CRUD  - LISTAR

@Controller
public class HolaControlador {

            //Listar Planetas
            @Autowired
            ImplementacionServiciosPlaneta  implementacionServiciosPlaneta;


            @GetMapping("/")
            public String  iniciar(Model parametros) {
               List <Planeta> listaPlanetas;

               listaPlanetas= (List <Planeta>) implementacionServiciosPlaneta.listarPlanetas();
               parametros.addAttribute("Planetas",listaPlanetas);
               return "html/inicio";
            }


 }


