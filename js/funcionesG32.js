function consultar() {
    $.ajax(
             {
                /*url     : 'https://g23bfb99f5036e6-bdpais.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/planeta/planeta',*/
                url     : 'https://gd2d1fb23ab6545-db202109302209.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/bike/bike',
                type    : 'GET',
                dataType: 'json',

                /* version 1
                 success:  function(json){
                            $("#idDivConsulta").empty();
                                for (i=0; i < json.items.length; i++){
                                    $("#idDivConsulta").append(json.items[i].id + " " + json.items[i].brand + " " + json.items[i].model + " " + json.items[i].name + " ");
                                }
                                console.log(json)
                            },
                */
                // version 2
                success: function(json){
                            $("#idDivConsulta").empty();
                            $("#idDivConsulta").append("<table>");
                            $("#idDivConsulta").append("<caption>Stock de Bicicletas</caption>");
                            $("#idDivConsulta").append("<tr><th>ID</th><th>Marca</th><th>Modelo</th><th>Categoria</th><th>Nombre</th></tr>");
                            for (i=0; i < json.items.length; i++){
                                $("#idDivConsulta").append("<tr>");
                                $("#idDivConsulta").append("<td>" + json.items[i].id + "</td>");
                                $("#idDivConsulta").append("<td>" + json.items[i].brand + "</td>");
                                $("#idDivConsulta").append("<td>" + json.items[i].model + "</td>");
                                $("#idDivConsulta").append("<td>" + json.items[i].category_id + "</td>");
                                $("#idDivConsulta").append("<td>" + json.items[i].name + "</td>");
                                $("#idDivConsulta").append("</tr>");
                            }
                            $("#idDivConsulta").append("</table>");
                            console.log(json)
                        },

                 error  : function(xhr,status){
                            console.log(xhr)
                        }
             }
    );
}


function insertar() {

    var bike;

    bike    = {id: 6, brand:"BMC", model:"2020", category_id: 1, name :"BMC Road Machine"};

    $.ajax (
        {

            /*url     : 'https://g23bfb99f5036e6-bdpais.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/planeta/planeta',*/
            url     : 'https://gd2d1fb23ab6545-db202109302209.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/bike/bike',
            type    : 'POST',
            data    :  bike,

            success : function(response){
                        console.log(response);
                        },
            error   : function(xhr,status){
                        console.log( xhr);
                        }
        }
    );
}

function borrar() {

    var bike;

    bike        = {id: 6};
    datosEnvio   = JSON.stringify(bike);

    $.ajax (
        {
            /*url         : 'https://g23bfb99f5036e6-bdpais.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/planeta/planeta',*/
            url         : 'https://gd2d1fb23ab6545-db202109302209.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/bike/bike',
            type        : 'DELETE',
            data        :  datosEnvio,
            contentType : 'application/json',

            success     : function(response){
                            console.log(response);
                            },
            error       : function(xhr,status){
                            console.log(xhr);
                            }
        }
    );

}

function actualizar() {

    bike        = {id: 6, brand:"BMC", model:"2020", category_id: 1, name:"BMC Road Machine"};
    datosEnvio  = JSON.stringify(bike);

    $.ajax (
                {
                    /*url         : 'https://g23bfb99f5036e6-bdpais.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/planeta/planeta',*/
                    url         : 'https://gd2d1fb23ab6545-db202109302209.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/bike/bike',
                    type        : 'PUT',
                    data        : datosEnvio,
                    contentType : 'application/json',

                    success     : function(response){
                                    console.log(response);
                                    },
                    error       : function(xhr,status){
                                    console.log( xhr);
                                    }
                }
            );
}

function consultarId() {

    var codigo = $("#idCodigo").val();

    $.ajax (
                {
                    /*url     : 'https://gd2d1fb23ab6545-db202109302209.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/bike/bike/' + codigo ,*/
                    url     : 'https://gd2d1fb23ab6545-db202109302209.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/bike/bike/' + id,
                    type    : 'GET',
                    dataType: 'json',

                    success : function(json){
                                $("#idDivConsulta").empty();
                                $("#idDivConsulta").append("<table>");
                                $("#idDivConsulta").append("<caption>Stock de Bicicletas</caption>");
                                $("#idDivConsulta").append("<tr><th>ID</th><th>Marca</th><th>Modelo</th><th>Categoria</th><th>Nombre</th></tr>");
                                    for (i=0; i < json.items.length; i++){
                                        $("#idDivConsulta").append("<tr>");
                                        $("#idDivConsulta").append("<td>" + json.items[i].id + "</td>");
                                        $("#idDivConsulta").append("<td>" + json.items[i].brand + "</td>");
                                        $("#idDivConsulta").append("<td>" + json.items[i].model + "</td>");
                                        $("#idDivConsulta").append("<td>" + json.items[i].category_id + "</td>");
                                        $("#idDivConsulta").append("<td>" + json.items[i].name + "</td>");
                                        $("#idDivConsulta").append("</tr>");
                                    }
                                $("#idDivConsulta").append("</table>");
                                
                                console.log(json)
                            },
                    error   : function(xhr,status){
                                alert('Operacion no satisfactoria,'+ xhr.status );
                            },
                }
            );
}





