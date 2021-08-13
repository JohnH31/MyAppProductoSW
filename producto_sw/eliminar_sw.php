<?php

include_once("connection.php");
$jsonArray = array();

if (isset($_GET["id_producto"])) {
    $id_producto = $_GET["id_producto"];
    $eliminar = "DELETE FROM tbl_producto WHERE id_producto = $id_producto";
    $resultado = mysqli_query($connection, $eliminar) or die ("Error " . mysqli_error($connection));

    $jsonArray["tbl_producto"][] = $resultado;
    echo json_encode($jsonArray);
    mysqli_close($connection);
}
else{

    echo json_encode($jsonArray);
    mysqli_close($connection);
}

?>