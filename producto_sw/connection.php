<?php

//variable para realizar la conexion
    $host = 'localhost';
    $username = 'root';
    $password = '';
    $dbname = 'bd_producto';

    //realizar la conexion
    $connection = mysqli_init();
    mysqli_real_connect($connection, $host, $username, $password, $dbname);
    mysqli_set_charset($connection, 'utf8');
    if (mysqli_connect_error($connection)) {
        die('error en la conexion '. mysqli_connect_error() .
        mysqli_report(MYSQLI_REPORT_ERROR | MYSQLI_REPORT_STRICT));
    }
    //else {
      //  echo 'Conexion exitosa';
    //}

?>