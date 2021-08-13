<?php
include_once("connection.php");
$jsonArray = array();

if (isset($_GET["id_producto"])) {
    $id_producto = $_GET["id_producto"];
    $nombre_producto = $_GET["nombre_producto"];
    $descripcion_producto = $_GET["descripcion_producto"];
    $categoria_producto = $_GET["categoria_producto"];
    $presio_producto = $_GET["presio_producto"];

    $actualizar = "UPDATE tbl_producto SET nombre_producto='$nombre_producto',descripcion_producto='
    $descripcion_producto',categoria_producto='$categoria_producto',presio_producto=
    $presio_producto WHERE id_producto=$id_producto";

    $resultado = mysqli_query($connection, $actualizar) or die ("Error " . mysqli_error($connection));
    $jsonArray["tbl_producto"][] = $resultado;
    echo json_encode($jsonArray);
    mysqli_close($connection);
}
else{
    echo json_encode($jsonArray);
    mysqli_close($connection);
}
?>