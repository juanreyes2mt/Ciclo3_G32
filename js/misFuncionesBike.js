/* Funciones para manejadores tabla BICICLETA */

function consultarBicicletas(){
    $.ajax({
        url:"https://gd2d1fb23ab6545-db202109302209.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/bike/bike",
        type:"GET",
        datatype:"JSON",
        success:function(respuestaBike){
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
        url:"https://gd2d1fb23ab6545-db202109302209.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/bike/bike",
        type:"POST",
        data:myBike,
        datatype:"JSON",
        success:function(respuestaBike){
            $("#consultaBike").empty();
            $("#id").val("");
            $("#brand").val("");
            $("#model").val("");
            $("#category_id").val("");
            $("#name").val("");
            consultarBicicletas();
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
        url     : "https://gd2d1fb23ab6545-db202109302209.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/bike/bike",
        type    : "PUT",
        data    : dataToSend,
        contentType:"application/JSON",
        datatype: "JSON",
        success : function(respuestaBike){
            $("#consultaBike").empty();
            $("#id").val("");
            $("#brand").val("");
            $("#model").val("");
            $("#category_id").val("");
            $("#name").val("");
            consultarBicicletas();
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
        url     : "https://gd2d1fb23ab6545-db202109302209.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/bike/bike",
        type    : "DELETE",
        data    : dataToSend,
        contentType:"application/JSON",
        datatype: "JSON",
        success : function(respuestaBike){
            $("#consultaBike").empty();
            consultarBicicletas();
            alert("Se ha eliminado el registro.")
        }
    });
}
