<?php

error_reporting(E_ERROR | E_PARSE);//ignorar warning

// Definición de la consulta
$manager = new MongoDB\Driver\Manager("mongodb://root:password@mongo:27017/admin");
$query = new MongoDB\Driver\Query([]);
$rows = $manager->executeQuery('laIslaDb.Jugador', $query);

// Verificar si se ha enviado un formulario por método POST
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $username = $_POST['username'];
    $email = $_POST['email'];
    $password = $_POST['password'];

    // Validar que no exista un usuario con el mismo nombre de usuario o correo electrónico
    $existingUser = null;
    foreach ($rows as $document) {
        if ($document->username == $username) {
            $existingUser = $document;
            break;
        }
    }

    if ($existingUser !== null) {
        // Si el usuario ya existe, mostrar un mensaje de error y salir del script
        echo 'El usuario ya existe.';
        exit();
    }

    // Si el usuario no existe, insertarlo en la base de datos
    $bulkWrite = new MongoDB\Driver\BulkWrite();
    $bulkWrite->insert(['username' => $username, 'email' => $email, 'password' => $password]);
    $insertResult = $manager->executeBulkWrite('reto3.usuarios', $bulkWrite);

    // Mostrar un mensaje de éxito
    header("Location: index.html");
    echo 'El usuario se ha registrado correctamente.';
}
?>
