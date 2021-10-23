package g32.reto3.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g32.reto3.Modelo.modeloCategoria;
import g32.reto3.Operaciones.operacionesCategoria;

@Service
public class serviciosCategoria {

    @Autowired
    private operacionesCategoria metodosCrud;

    public List<modeloCategoria> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<modeloCategoria> getCategoria(int CategoriaId) {
        return metodosCrud.getCategoria(CategoriaId);
    }

    public modeloCategoria save(modeloCategoria categoria) {
        if (categoria.getId()== null) {
            return metodosCrud.save(categoria);
        } else {
            Optional<modeloCategoria> categoria1 = metodosCrud.getCategoria(categoria.getId());
            if (categoria1.isEmpty()) {
                return metodosCrud.save(categoria);
            } else {
                return categoria;
            }
        }
    }

    public modeloCategoria update(modeloCategoria categoria){
        if(categoria.getId()!=null){
            Optional<modeloCategoria>g=metodosCrud.getCategoria(categoria.getId());
            if(!g.isEmpty()){
                if(categoria.getDescription()!=null){
                    g.get().setDescription(categoria.getDescription());
                }
                if(categoria.getName()!=null){
                    g.get().setName(categoria.getName());
                }
                return metodosCrud.save(g.get());
            }
        }
        return categoria;
    }
    public boolean deletecategoria(int categoriaId){
        Boolean d=getCategoria(categoriaId).map(categoria -> {
            metodosCrud.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }
    
    
}
