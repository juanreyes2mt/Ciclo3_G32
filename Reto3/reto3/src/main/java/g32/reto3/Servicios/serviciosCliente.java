package g32.reto3.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g32.reto3.Modelo.modeloCliente;
import g32.reto3.Operaciones.operacionesCliente;

@Service
public class serviciosCliente {

    @Autowired
    private operacionesCliente metodosCrud;
    
    public List<modeloCliente> getAll(){
       return metodosCrud.getAll();
   }
    
     public Optional<modeloCliente> getClient(int clientId) {
       return metodosCrud.getCliente(clientId);
   }

   public modeloCliente save(modeloCliente client){
       if(client.getIdClient()==null){
           return metodosCrud.save(client);
       }else{
           Optional<modeloCliente> e= metodosCrud.getCliente(client.getIdClient());
           if(e.isEmpty()){
               return metodosCrud.save(client);
           }else{
               return client;
           }
       }
   }

   public modeloCliente update(modeloCliente client){
       if(client.getIdClient()!=null){
           Optional<modeloCliente> e= metodosCrud.getCliente(client.getIdClient());
           if(!e.isEmpty()){
               if(client.getName()!=null){
                   e.get().setName(client.getName());
               }
               if(client.getAge()!=null){
                   e.get().setAge(client.getAge());
               }
               if(client.getPassword()!=null){
                   e.get().setPassword(client.getPassword());
               }
               metodosCrud.save(e.get());
               return e.get();
           }else{
               return client;
           }
       }else{
           return client;
       }
   }

   public boolean deleteClient(int clientId) {
       Boolean aBoolean = getClient(clientId).map(client -> {
           metodosCrud.delete(client);
           return true;
       }).orElse(false);
       return aBoolean;
   }

    
}
