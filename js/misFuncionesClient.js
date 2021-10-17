/* Funciones para manejadores de tabla CLIENTE */

function consultarClientes(){
    $.ajax({
        url     :"https://gd2d1fb23ab6545-db202109302209.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/client/client",
        type    :"GET",
        datatype:"JSON",
        success:function(respuestaClient){
            console.log(respuestaClient);
            listarClientes(respuestaClient.items);
        }
    });
}

function listarClientes(items){

    let myTable="<table>";
    for(i=0;i<items.length;i++){
        myTable+="<tr>";
        myTable+="<td class='tabla'>"+items[i].id+"</td>";
        myTable+="<td class='tabla'>"+items[i].name+"</td>";
        myTable+="<td class='tabla'>"+items[i].email+"</td>";
        myTable+="<td class='tabla'>"+items[i].age+"</td>";
        myTable+="<td> <button class='boton' onclick='borrarCliente("+items[i].id+")'>Eliminar</button>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#consultaClient").append(myTable);

}

function guardarCliente(){
    let myClient={
        id:$("#id").val(),
        name:$("#name").val(),
        email:$("#email").val(),
        age:$("#age").val(),
    };
    let dataToSend=JSON.stringify(myClient);
    $.ajax({
        url     :"https://gd2d1fb23ab6545-db202109302209.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/client/client",
        type    :"POST",
        data    :myClient,
        datatype:"JSON",
        success:function(respuestaClient){
            $("#consultaClient").empty();
            $("#id").val("");
            $("#name").val("");
            $("#email").val("");
            $("#age").val("");
            consultarClientes();
            alert("Cliente grabado satisfactoriamente.")
        }
    });
}

function editarCliente(){
    let myClient={
        id:$("#id").val(),
        name:$("#name").val(),
        email:$("#email").val(),
        age:$("#age").val(),

    };
    console.log(myClient);
    let dataToSend=JSON.stringify(myClient);
    $.ajax({
        url     :"https://gd2d1fb23ab6545-db202109302209.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/client/client",
        type    :"PUT",
        data    :dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuestaClient){
            $("#consultaClient").empty();
            $("#id").val("");
            $("#name").val("");
            $("#email").val("");
            $("#age").val("");
            consultarClientes();
            alert("Se ha actualizado el registro.")
        }
    });
}

function borrarCliente(idCliente){
    let myClient={
        id:idCliente
    };
    let dataToSend=JSON.stringify(myClient);
    $.ajax({
        url     :"https://gd2d1fb23ab6545-db202109302209.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/client/client",
        type    :"DELETE",
        data    :dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuestaClient){
            $("#consultaClient").empty();
            consultarClientes();
            alert("Se ha eliminado el registro.")
        }
    });
}

