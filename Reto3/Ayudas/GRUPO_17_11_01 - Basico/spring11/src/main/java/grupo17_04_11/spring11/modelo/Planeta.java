package grupo17_04_11.spring11.modelo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Data
public class Planeta {

    private Integer codigo;
    private String  nombre;


}