package g32.reto3.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g32.reto3.Modelo.modeloMensaje;
import g32.reto3.Operaciones.operacionesMensaje;

@Service
public class serviciosMensaje {

    @Autowired
    private operacionesMensaje metodosCrud;

    public List<modeloMensaje> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<modeloMensaje> getMessage(int messageId) {
        return metodosCrud.getMessage(messageId);
    }

    public modeloMensaje save(modeloMensaje message){
        if(message.getIdMessage()==null){
            return metodosCrud.save(message);
        }else{
            Optional<modeloMensaje> e= metodosCrud.getMessage(message.getIdMessage());
            if(e.isEmpty()){
                return metodosCrud.save(message);
            }else{
                return message;
            }
        }
    }

    public modeloMensaje update(modeloMensaje message){
        if(message.getIdMessage()!=null){
            Optional<modeloMensaje> e= metodosCrud.getMessage(message.getIdMessage());
            if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    
}
