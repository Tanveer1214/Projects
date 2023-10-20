<?php
    $host = '127.0.0.1:3307'; 
    $username = 'root'; 
    $password = ''; 
    $database = 'library_system'; 

    $connection = mysqli_connect($host, $username, $password, $database);

    if (!$connection) {
        die('Database connection failed: ' . mysqli_connect_error());
    }

    mysqli_set_charset($connection, 'utf8');
?>