<?php

include_once("connection.php");
$jsonArray = array();
$consulta = "SELECT * FROM tbl_producto";
$resultado = mysqli_query($connection, $consulta) or die ("Error " . mysqli_error($connection));

if (mysqli_num_rows($resultado) > 0) {

    while ($registro = mysqli_fetch_array($resultado)) {
    $jsonArray["tbl_producto"][] = $registro;
    }
    echo json_encode($jsonArray);
    mysqli_close($connection);
}
else {
    $resultadoVacio["id_producto"] = "...";
    $resultadoVacio["nombre_producto"] = "...";
        $resultadoVacio["descripcion_producto"] = "...";
        $resultadoVacio["categoria_producto"] = "...";
        $resultadoVacio["presio_producto"] = "...";
        $jsonArray["tbl_producto"][] = $resultadoVacio;
        
    echo json_encode($jsonArray);
    mysqli_close($connection);
}



?>