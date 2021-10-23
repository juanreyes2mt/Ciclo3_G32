package grupo17_04_11.spring11.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
//@Data

@Entity
//@Table(name = "planeta")
public class Planeta {

    @Id
    private Integer codigo;
    private String  nombre;

   

}