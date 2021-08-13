<?php

include_once("connection.php");

//se crea el array que contendra la informacion ya sea para trasladar o recepciona
$jsonArray = array();

//definimos los campos que seran utilizados
if (isset($_GET["nombre_producto"]) && isset($_GET["descripcion_producto"]) 
&& isset($_GET["categoria_producto"]) && isset($_GET["presio_producto"])) {
    //declarar variables que definieran los datos a insertar
    $nombre_producto = $_GET["nombre_producto"];
    $descripcion_producto = $_GET["descripcion_producto"];
    $categoria_producto = $_GET["categoria_producto"];
    $presio_producto = $_GET["presio_producto"];

    //Declaracion de la consulta a realizar
    $insertar = "INSERT INTO tbl_producto (nombre_producto, descripcion_producto, categoria_producto, presio_producto)
                VALUES ('{$nombre_producto}','{$descripcion_producto}','{$categoria_producto}',{$presio_producto});";

    //oBTENEMOS EL RESULTADO DE LA CONCEXION Y LA CONSULTA QUE SE FUE A REALIZAR EN LA BASE DE DATOS 
    $resultado = mysqli_query($connection, $insertar) or die('error' . mysqli_error($connection));

    //Agregar el resultado con datos al array
    $jsonArray["tbl_producto"][] = $resultado;

    //asignacion del arreglo al JSON para la estructura a manipular
    echo json_encode($jsonArray);
    mysqli_close($connection);

}
else {
    echo json_encode($jsonArray);
    mysqli_close($connection);
    echo 'Datos no insertados';

}

?>