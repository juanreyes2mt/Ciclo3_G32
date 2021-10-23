package g32.reto3.Servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g32.reto3.Modelo.modeloBicicleta;
import g32.reto3.Operaciones.operacionesBicicleta;

@Service
public class serviciosBicicleta {

    @Autowired
    private operacionesBicicleta metodosCrud;

    public List<modeloBicicleta> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<modeloBicicleta> getBike(int bikeId) {
        return metodosCrud.getBike(bikeId);
    }

    public modeloBicicleta save(modeloBicicleta bike){
        if(bike.getId()==null){
            return metodosCrud.save(bike);
        }else{
            Optional<modeloBicicleta> e=metodosCrud.getBike(bike.getId());
            if(e.isEmpty()){
                return metodosCrud.save(bike);
            }else{
                return bike;
            }
        }
    }

    public modeloBicicleta update(modeloBicicleta bike){
        if(bike.getId()!=null){
            Optional<modeloBicicleta> e=metodosCrud.getBike(bike.getId());
            if(!e.isEmpty()){
                if(bike.getName()!=null){
                    e.get().setName(bike.getName());
                }
                if(bike.getBrand()!=null){
                    e.get().setBrand(bike.getBrand());
                }
                if(bike.getYear()!=null){
                    e.get().setYear(bike.getYear());
                }
                if(bike.getDescription()!=null){
                    e.get().setDescription(bike.getDescription());
                }
                if(bike.getCategory()!=null){
                    e.get().setCategory(bike.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return bike;
            }
        }else{
            return bike;
        }
    }


    public boolean deleteBike(int bikeId) {
        Boolean aBoolean = getBike(bikeId).map(bike -> {
            metodosCrud.delete(bike);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
