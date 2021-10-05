/***** MANEJADORES TABLA CLIENTE *****/

/*GET */
SELECT * FROM CLIENT;

/*POST */
BEGIN
    INSERT INTO CLIENT (ID,NAME,EMAIL,AGE) VALUES(:id, :name, :email, :age);
    :status_code:=201;
END;

/*PUT */
BEGIN
    UPDATE CLIENT SET NAME=:name, EMAIL=:email, AGE=:age WHERE ID=:id;
    :status_code:=201;
END;

/*DELETE */
BEGIN
    DELETE FROM CLIENT WHERE ID=:id;
    :status_code:=204;
END;


SELECT * FROM CLIENT WHERE ID=:id;


/***** MANEJADORES TABLA MENSAJE *****/

/*GET */
SELECT * FROM MENSAJE;

/*POST */
BEGIN
    INSERT INTO MENSAJE (ID,MESSAGETEXT) VALUES(:id, :messagetext);
    :status_code:=201;
END;

/*PUT */
BEGIN
    UPDATE MESSAGE SET  MESSAGETEXT=:messagetext WHERE ID=:id;
    :status_code:=201;
END;

/*DELETE */
BEGIN
    DELETE FROM MESSAGE WHERE ID=:id;
    :status_code:=204;
END;

/*GET MESSAGE */
SELECT * FROM MESSAGE WHERE ID=:id

