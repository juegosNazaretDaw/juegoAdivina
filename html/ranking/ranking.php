<?php
// Función para obtener los mejores jugadores
function getTopPlayers() {
    $manager = new MongoDB\Driver\Manager("mongodb://root:password@mongo:27017/admin");

    $pipeline = [
        [
            '$sort' => [
                'puntos' => -1,
                'nombre' => 1,
                'partidasGanadas' => -1,
                'partidasJugadas' => -1
            ]
        ],
        [
            '$limit' => 10
        ],
        [
            '$project' => [
                '_id' => 0,
                'nombre' => 1,
                'puntos' => 1,
                'partidasGanadas' => 1,
                'partidasJugadas' => 1
            ]
        ]
    ];

    $command = new MongoDB\Driver\Command([
        'aggregate' => 'Jugador',
        'pipeline' => $pipeline,
        'cursor' => new stdClass,
    ]);

    $cursor = $manager->executeCommand('laIslaDb', $command);

    $players = [];
    foreach ($cursor as $document) {
        $players[] = [
            'nombre' => $document->nombre,
            'puntos' => $document->puntos,
            'partidasGanadas' => $document->partidasGanadas,
            'partidasJugadas' => $document->partidasJugadas
        ];
    }

    return $players;
}

// Obtener los mejores jugadores
$topPlayers = getTopPlayers();
?>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Ranking</title>
    <link rel="stylesheet" href="ranking.css" />
</head>
<body>
    <div id="app">
        <h1>Ranking</h1>
        <a href="../index.html" class="btn">Volver al menú inicio</a>
        
        
        <table>
            <thead>
                <tr>
                    <th>Posicion</th>
                    <th>Nombre</th>
                    <th>Puntos</th>
                    <th>Partidas Ganadas</th>
                    <th>Partidas Jugadas</th>
                </tr>
            </thead>
            <tbody>
                
                <?php foreach ($topPlayers as $position => $player) { ?>
                    <tr>
                        <td><?php echo $position + 1; ?></td>
                        <td><?php echo $player['nombre']; ?></td>
                        <td><?php echo $player['puntos']; ?></td>
                        <td><?php echo $player['partidasGanadas']; ?></td>
                        <td><?php echo $player['partidasJugadas']; ?></td>
                    </tr>
                <?php } ?>
            </tbody>
        </table>
    </div>
    <script src="script.js"></script>

</body>
</html>
