/* Funciones para manejadores tabla BICICLETA */

function ConsultarBicicletas(){
    $.ajax({
        url     :"https://gd2d1fb23ab6545-db202109302209.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/bike/bike",
        type    :"GET",
        datatype:"JSON",
        success :function(respuestaBike){
            console.log(respuestaBike);
            listarBicicletas(respuestaBike.items);
        }
    });
}

function listarBicicletas(items){

    let myTable="<table>";
    for(i=0;i<items.length;i++){
        myTable+="<tr>";
        myTable+="<td class='tabla'>"+items[i].id+"</td>";
        myTable+="<td class='tabla'>"+items[i].brand+"</td>";
        myTable+="<td class='tabla'>"+items[i].model+"</td>";
        myTable+="<td class='tabla'>"+items[i].category_id+"</td>";
        myTable+="<td class='tabla'>"+items[i].name+"</td>";
        myTable+="<td> <button class='boton' onclick='borrarBicicleta("+items[i].id+")'>Eliminar</button>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#consultaBike").append(myTable);

}

function guardarBicicleta(){
    let myBike={
        id:$("#id").val(),
        brand:$("#brand").val(),
        model:$("#model").val(),
        category_id:$("#category_id").val(),
        name:$("#name").val(),
    };
    let dataToSend=JSON.stringify(myBike);
    $.ajax({
        url     :"https://gd2d1fb23ab6545-db202109302209.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/bike/bike",
        type    :"POST",
        data    :myBike,
        datatype:"JSON",
        success:function(respuestaBike){
            $("#consultaBike").empty();
            $("#id").val("");
            $("#brand").val("");
            $("#model").val("");
            $("#category_id").val("");
            $("#name").val("");
            ConsultarBicicletas();
            alert("Bicicleta grabada satisfactoriamente")
        }
    });
}

function editarBicicleta(){
    let myBike={
        id:$("#id").val(),
        brand:$("#brand").val(),
        model:$("#model").val(),
        category_id:$("#category_id").val(),
        name:$("#name").val(),
    };
    console.log(myBike);
    let dataToSend=JSON.stringify(myBike);
    $.ajax({
        url     :"https://gd2d1fb23ab6545-db202109302209.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/bike/bike",
        type    :"PUT",
        data    :dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuestaBike){
            $("#consultaBike").empty();
            $("#id").val("");
            $("#brand").val("");
            $("#model").val("");
            $("#category_id").val("");
            $("#name").val("");
            ConsultarBicicletas();
            alert("Se ha actualizado el registro.")
        }
    });
}

function borrarBicicleta(idBicicleta){
    let myBike={
        id:idBicicleta
    };
    let dataToSend=JSON.stringify(myBike);
    $.ajax({
        url     :"https://gd2d1fb23ab6545-db202109302209.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/bike/bike",
        type    :"DELETE",
        data    :dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuestaBike){
            $("#consultaBike").empty();
            ConsultarBicicletas();
            alert("Se ha eliminado el registro.")
        }
    });
}

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
    let dataToSend=JSON.stringify(myClient2);
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
        url     :"https://g42463fc9ec0dbe-db202109261450.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/client/client",
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
        url     :"https://g42463fc9ec0dbe-db202109261450.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/client/client",
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


/* Funciones para manejadores de tabla CLIENTE ejemplo tutoria*/

function traerInformacion(){
    $.ajax({
        url:"https://g42463fc9ec0dbe-db202109261450.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/client/client",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            pintarRespuesta(respuesta.items);
        }
    });
}

function pintarRespuesta(items){

    let myTable="<table>";
    for(i=0;i<items.length;i++){
        myTable+="<tr>";
        myTable+="<td>"+items[i].id+"</td>";
        myTable+="<td>"+items[i].name+"</td>";
        myTable+="<td>"+items[i].email+"</td>";
        myTable+="<td>"+items[i].age+"</td>";
        myTable+="<td> <button onclick='borrarElemento("+items[i].id+")'>Borrar</button>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#resultado").append(myTable);

}

function guardarInformacion(){
    let myData={
        id:$("#id").val(),
        name:$("#name").val(),
        email:$("#email").val(),
        age:$("#age").val(),
    };
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"https://g42463fc9ec0dbe-db202109261450.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/client/client",
        type:"POST",
        data:myData,
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();
            $("#id").val("");
            $("#name").val("");
            $("#email").val("");
            $("#age").val("");
            traerInformacion();
            alert("se ha guardado el dato")
        }
    });
}


function editarInformacion(){
    let myData={
        id:$("#id").val(),
        name:$("#name").val(),
        email:$("#email").val(),
        age:$("#age").val(),

    };
    console.log(myData);
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"https://g42463fc9ec0dbe-db202109261450.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/client/client",
        type:"PUT",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();
            $("#id").val("");
            $("#name").val("");
            $("#email").val("");
            $("#age").val("");
            traerInformacion();
            alert("se ha Actualizado")
        }
    });
}

function borrarElemento(idElemento){
    let myData={
        id:idElemento
    };
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"https://g42463fc9ec0dbe-db202109261450.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/client/client",
        type:"DELETE",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();
            traerInformacion();
            alert("Se ha Eliminado.")
        }
    });
}

