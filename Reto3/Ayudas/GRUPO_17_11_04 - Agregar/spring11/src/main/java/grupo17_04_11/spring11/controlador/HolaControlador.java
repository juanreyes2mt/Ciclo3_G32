package grupo17_04_11.spring11.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import grupo17_04_11.spring11.modelo.Planeta;
import grupo17_04_11.spring11.servicio.ImplementacionServiciosPlaneta;




@Controller
public class HolaControlador {

            //Visualizacion Planetas

            @Autowired
            ImplementacionServiciosPlaneta  implementacionServiciosPlaneta;
            @GetMapping("/")
            public String  iniciar(Model parametros) {
               List <Planeta> listaPlanetas;

               listaPlanetas= (List <Planeta>) implementacionServiciosPlaneta.listarPlanetas();
               parametros.addAttribute("Planetas",listaPlanetas);
               return "html/inicio";
            }

            @GetMapping("/agregar")
            public String agregar(Planeta planeta){
               return "html/crear";
            }

            @PostMapping("/guardar")
            public String guardar(Planeta planeta){
               implementacionServiciosPlaneta.guardar(planeta);
               return "redirect:/";
            }

 }


