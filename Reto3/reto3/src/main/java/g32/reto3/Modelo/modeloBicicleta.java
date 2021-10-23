package g32.reto3.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bike")

public class modeloBicicleta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("bikes")
    private modeloCategoria category;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "bike")
    @JsonIgnoreProperties({"bike", "client"})
    private List<modeloMensaje> messages;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "bike")
    @JsonIgnoreProperties({"bike", "client"})
    private List<modeloReservas> reservations;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return this.year;
    }
        
   
    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public modeloCategoria getCategory() {
        return this.category;
    }

    public void setCategory(modeloCategoria category) {
        this.category = category;
    }

    public List<modeloMensaje> getMessages() {
        return this.messages;
    }

    public void setMessages(List<modeloMensaje> messages) {
        this.messages = messages;
    }

    public List<modeloReservas> getReservations() {
        return this.reservations;
    }

    public void setReservations(List<modeloReservas> reservations) {
        this.reservations = reservations;
    }
    
    public modeloBicicleta() {
    }

    public modeloBicicleta(Integer id, String name, String brand, Integer year, String description, modeloCategoria category, List<modeloMensaje> messages, List<modeloReservas> reservations) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.year = year;
        this.description = description;
        this.category = category;
        this.messages = messages;
        this.reservations = reservations;
    }
    
}