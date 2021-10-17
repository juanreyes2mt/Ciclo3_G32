/* Funciones para manejadores tabla BICICLETA */

function ConsultarMensajes(){
    $.ajax({
        url     :"https://gd2d1fb23ab6545-db202109302209.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/message/message",
        type    :"GET",
        datatype:"JSON",
        success :function(respuestaMessage){
            console.log(respuestaMessage);
            listarBicicletas(respuestaMessage.items);
        }
    });
}

function listarMensajes(items){

    let myTable="<table>";
    for(i=0;i<items.length;i++){
        myTable+="<tr>";
        myTable+="<td class='tabla'>"+items[i].id+"</td>";
        myTable+="<td class='tabla'>"+items[i].messagetext+"</td>";
        myTable+="<td> <button class='boton' onclick='borrarMensaje("+items[i].id+")'>Eliminar</button>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#consultaBike").append(myTable);
}

function guardarMensaje(){
    let myMessage={
        id:$("#id").val(),
        messagetext:$("#messagetext").val(),
    };
    let dataToSend=JSON.stringify(myMessage);
    $.ajax({
        url     :"https://gd2d1fb23ab6545-db202109302209.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/message/message",
        type    :"POST",
        data    :myBike,
        datatype:"JSON",
        success:function(respuestaMessage){
            $("#consultaMessage").empty();
            $("#id").val("");
            $("#messagetext").val("");
            ConsultarMensajes();
            alert("Mensaje grabado satisfactoriamente")
        }
    });
}

function editarMensaje(){
    let myMessage={
        id:$("#id").val(),
        messagetext:$("#messagetext").val(),
    };
    console.log(myMessage);
    let dataToSend=JSON.stringify(myMessage);
    $.ajax({
        url     :"https://gd2d1fb23ab6545-db202109302209.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/message/message",
        type    :"PUT",
        data    :dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuestaMessage){
            $("#consultaMessage").empty();
            $("#id").val("");
            $("#messagetext").val("");
            ConsultarMensajes();
            alert("Se ha actualizado el mensaje.")
        }
    });
}

function borrarMensaje(idMensaje){
    let myMessage={
        id:idMensaje
    };
    let dataToSend=JSON.stringify(myMessage);
    $.ajax({
        url     :"https://gd2d1fb23ab6545-db202109302209.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/message/message",
        type    :"DELETE",
        data    :dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuestaMessage){
            $("#consultaMessage").empty();
            ConsultarMensajes();
            alert("Se ha eliminado el mensaje.")
        }
    });
}
