<?php

include_once("connection.php");
$jsonArray = array();
if (isset($_GET["id_producto"])) {
    $id_producto = $_GET["id_producto"];
    $buscarId = "SELECT nombre_producto, descripcion_producto, categoria_producto, presio_producto
    FROM tbl_producto WHERE id_producto =$id_producto";
    $resultado = mysqli_query($connection, $buscarId) or die ("Error " . mysqli_error($connection));

    if (mysqli_num_rows($resultado)>0) {
        $registros = mysqli_fetch_array($resultado);
        $jsonArray["tbl_producto"][]= $registros;
    }
    else{
        $resultadoVacio["nombre_producto"] = "...";
        $resultadoVacio["descripcion_producto"] = "...";
        $resultadoVacio["categoria_producto"] = "...";
        $resultadoVacio["presio_producto"] = "...";
        $jsonArray["tbl_producto"][] = $resultadoVacio;
      
        //$jsonArray["tbl_cliente"][]= $registros;
        //echo "no se encontro registro";
    }
    echo json_encode($jsonArray);
    mysqli_close($connection);
}
else{
    echo json_encode($jsonArray);
    mysqli_close($connection);
    echo "Datos no encontrados";

}



?>