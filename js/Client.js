function consultarClientes(){
    $.ajax({
        //url:"https://g42463fc9ec0dbe-db202109261450.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/client/client",
        url:"https://gd2d1fb23ab6545-db202109302209.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/client/client",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            mostrarClientes(respuesta.items);
        }

    });
}

function mostrarClientes(items){

    let myTable="<table>";
    for(i=0;i<items.length;i++){
        myTable+="<tr class='tabla'>";
        myTable+="<td>"+items[i].id+"</td>";
        myTable+="<td>"+items[i].name+"</td>";
        myTable+="<td>"+items[i].email+"</td>";
        myTable+="<td>"+items[i].age+"</td>";
        myTable+="<td> <button class='boton' onclick='eliminarCliente("+items[i].id+")'>Eliminar</button>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#resultado").append(myTable);

}
function guardarCliente(){
    let myData={
        id:$("#id").val(),
        name:$("#name").val(),
        email:$("#email").val(),
        age:$("#age").val(),
    };
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"https://gd2d1fb23ab6545-db202109302209.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/client/client",
        type:"POST",
        data:myData,
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();
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
    let myData={
        id:$("#id").val(),
        name:$("#name").val(),
        email:$("#email").val(),
        age:$("#age").val(),
    };
    console.log(myData);
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"https://gd2d1fb23ab6545-db202109302209.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/client/client",
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
            consultarClientes();
            alert("Se ha actualizado el registro satisfactoriamente.")
        }
    });
}

function eliminarCliente(idElemento){
    let myData={
        id:idElemento
    };
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"https://gd2d1fb23ab6545-db202109302209.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/client/client",
        type:"DELETE",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();
            consultarClientes();
            alert("Se ha eliminado el registro satisfactoriamente.")
        }
    });
}

