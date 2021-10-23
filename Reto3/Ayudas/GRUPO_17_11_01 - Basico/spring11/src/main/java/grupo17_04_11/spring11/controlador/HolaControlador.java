package grupo17_04_11.spring11.controlador;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import grupo17_04_11.spring11.modelo.*;
import java.util.ArrayList;





//  version 1  llamar a pagina en la plantilla templates. Si el usuario no especifica ruta
//             por defecto se va a la pagina que esta en la carpeta static
// @Controller
// public class HolaControlador {

//             @GetMapping("/adios")
//             public String  saludar() {

//                  return "html/index2";
//             }

// }

// Version 2  Creando datos apartir de la clase modelo para enviarlo a la pagina index3
// @Controller
// public class HolaControlador {

//             @GetMapping("/hola")
//             public String  saludar(Model parametros) {
//                  String parametroPagina;

//                  parametroPagina = "ENVIAR VALORES DE TEXTO A LA PAGINA";
//                  parametros.addAttribute("llavePagina",parametroPagina);
//                  return "html/index3";
//             }

// }


// Version 3    : Enviar un objeto planeta a la página
// @Controller
// public class HolaControlador {

//             @GetMapping("/hola")
//             public String  saludar(Model parametros) {
//                      Planeta miPlaneta;

//                     // Enviar un objeto planeta como  párametro;

//                     miPlaneta= new Planeta();
//                     miPlaneta.setCodigo(1);
//                     miPlaneta.setNombre("Mercurio");
//                     parametros.addAttribute("codigoPlaneta",miPlaneta.getCodigo());
//                     parametros.addAttribute("nombrePlaneta",miPlaneta.getNombre());

//                     return "html/index4";
//             }

//  }


//Version 4:  Enviar texto y un ArrayList de Planetas a la página
//            http://puntocomnoesunlenguaje.blogspot.com/2013/02/arraylist-de-objetos-en-java.html
//            https://javadesdecero.es/arrays/bucle-for-each/

// @Controller
// public class HolaControlador {

//             @GetMapping("/hola")
//             public String  saludar(Model parametros) {
//                     ArrayList<Planeta> arrayListPlanetas;
//                     Planeta miPlanetaM;
//                     Planeta miPlanetaV;
//                     Planeta miPlanetaT;

//                     arrayListPlanetas   = new ArrayList();

//                     // Adicionar planetas al Arraylist

//                     miPlanetaM= new Planeta();
//                     miPlanetaM.setCodigo(1);
//                     miPlanetaM.setNombre("Mercurio");

//                     miPlanetaV= new Planeta();
//                     miPlanetaV.setCodigo(2);
//                     miPlanetaV.setNombre("Venus");

//                     miPlanetaT= new Planeta();
//                     miPlanetaT.setCodigo(3);
//                     miPlanetaT.setNombre("Tierra");

//                     arrayListPlanetas.add(miPlanetaM);
//                     arrayListPlanetas.add(miPlanetaV);
//                     arrayListPlanetas.add(miPlanetaT);

//                     // Enviar un objeto planeta como  parametro
//                     parametros.addAttribute("Planetas",arrayListPlanetas);


//                     return "html/index5";
//                }


// }


