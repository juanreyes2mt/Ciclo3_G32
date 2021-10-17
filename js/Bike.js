function consultarBicicletas(){
    $.ajax({
        //url:"https://g42463fc9ec0dbe-db202109261450.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/client/client",
        url:"https://gd2d1fb23ab6545-db202109302209.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/bike/bike",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            mostrarBicicletas(respuesta.items);
        }

    });
}

function mostrarBicicletas(items){

    let myTable="<table>";
    for(i=0;i<items.length;i++){
        myTable+="<tr class='tabla'>";
        myTable+="<td>"+items[i].id+"</td>";
        myTable+="<td>"+items[i].brand+"</td>";
        myTable+="<td>"+items[i].model+"</td>";
        myTable+="<td>"+items[i].category_id+"</td>";
        myTable+="<td>"+items[i].name+"</td>";
        myTable+="<td> <button class='boton' onclick='eliminarBicicleta("+items[i].id+")'>Eliminar</button>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#resultado").append(myTable);

}
function guardarBicicleta(){
    let myData={
        id:$("#id").val(),
        brand:$("#brand").val(),
        model:$("#model").val(),
        category_id:$("#category_id").val(),
        name:$("#name").val(),
    };
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"https://gd2d1fb23ab6545-db202109302209.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/bike/bike",
        type:"POST",
        data:myData,
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();
            $("#id").val("");
            $("#brand").val("");
            $("#model").val("");
            $("#category_id").val("");
            $("#name").val("");
            consultarBicicletas();
            alert("Bicicleta grabada satisfactoriamente.")
        }
    });
}


function editarBicicleta(){
    let myData={
        id:$("#id").val(),
        brand:$("#brand").val(),
        model:$("#model").val(),
        category_id:$("#category_id").val(),
        name:$("#name").val(),
    };
    console.log(myData);
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"https://gd2d1fb23ab6545-db202109302209.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/bike/bike",
        type:"PUT",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();
            $("#id").val("");
            $("#brand").val("");
            $("#model").val("");
            $("#category_id").val("");
            $("#name").val("");
            consultarBicicletas();
            alert("Se ha actualizado el registro satisfactoriamente.")
        }
    });
}

function eliminarBicicleta(idElemento){
    let myData={
        id:idElemento
    };
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"https://gd2d1fb23ab6545-db202109302209.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/bike/bike",
        type:"DELETE",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();
            consultarBicicletas();
            alert("Se ha eliminado el registro satisfactoriamente.")
        }
    });
}

