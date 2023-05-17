<?php

error_reporting(E_ERROR | E_PARSE);//ignorar warning


// Definición de la consulta
$manager = new MongoDB\Driver\Manager("mongodb://root:password@mongo:27017/admin");
$query = new MongoDB\Driver\Query([]);
$rows = $manager->executeQuery('laIslaDb.Jugador', $query);

// Comprobar si se ha enviado el formulario por el método POST
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
  $email = $_POST['email'];
  $password = $_POST['password'];

  // Verificar si existe un usuario con ese email y contraseña
  $authenticatedUser = null;
  foreach ($rows as $document) {
    if ($document->email == $email && $document->password == $password) {
      $authenticatedUser = $document;
      break;
    }
  }

  if ($authenticatedUser !== null) {
    // El usuario se ha autenticado correctamente

    // Redireccionar al index.html
    header("Location: index.html");
  } else {
    // El usuario no se ha autenticado correctamente
    echo "Email o contraseña incorrectos.";
  }
}
?>
