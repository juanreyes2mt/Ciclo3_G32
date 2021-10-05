SELECT * FROM BICICLETA;

BEGIN
    INSERT INTO BICICLETA(ID, BRAND, MODEL, CATEGORY_ID, NAME) VALUES (:id,:brand,:model,:category_id,:name);
    :status_code :=201;
END;

BEGIN
    UPDATE BICICLETA SET BRAND =:brand, MODEL =:model, CATEGORY_ID =:category_id, NAME =:name WHERE ID =:id;
    :status_code :=201;
END;

BEGIN
    DELETE FROM BICICLETA WHERE ID=:id;
    :status_code:=204; 
END;

SELECT * FROM BICICLETA WHERE ID=:id