### Crear la base de datos (En Mongo Shell)

```sh
# Crear la base de datos y usar la
use laIslaDb

# Crear las collecciones

db.createCollection("Jugador", {
   validator: {
      $jsonSchema: {
         bsonType: "object",
         required: [ "nombre", "contrasena", "email", "ranking", "puntos", "partidasJugadas", "partidasGanadas" ],
         properties: {
            nombre: {
               bsonType: "string",
               description: "must be a string and is required"
            },
            contrasena: {
               bsonType: "string",
               description: "must be a string and is required"
            },
            email: {
               bsonType: "string",
               description: "must be a string and is required"
            },
            ranking: {
               bsonType: "int",
               description: "must be an integer and is required"
            },
            puntos: {
               bsonType: "int",
               description: "must be an integer and is required"
            },
            partidasJugadas: {
               bsonType: "int",
               description: "must be an integer and is required"
            },
            partidasGanadas: {
               bsonType: "int",
               description: "must be an integer and is required"
            }
         }
      }
   },
   validationLevel: "strict",
   validationAction: "error"
});

db.Jugador.createIndex({ nombre: 1 }, { unique: true });
db.Jugador.createIndex({ email: 1 }, { unique: true });

db.createCollection("Partida", {
   validator: {
      $jsonSchema: {
         bsonType: "object",
         required: [ "id", "fecha", "puntosGanados"],
         properties: {
            id: {
               bsonType: "int",
               description: "must be an integer and is required"
            },
            fecha: {
               bsonType: "date",
               description: "must be a date and is required"
            },
            puntosGanados: {
               bsonType: "int",
               description: "must be an integer and is required"
            }
         }
      }
   }
});

db.createCollection("DetallePartida", {
   validator: {
      $jsonSchema: {
         bsonType: "object",
         required: [ "nombreJugador", "idPartida", "puntos" ],
         properties: {
            nombreJugador: {
               bsonType: "string",
               description: "must be a string and is required"
            },
            idPartida: {
               bsonType: "int",
               description: "must be an integer and is required"
            },
            puntos: {
               bsonType: "int",
               description: "must be an integer and is required"
            }
         }
      }
   },
   indexes: [
      {
         key: { "nombreJugador": 1, "idPartida": 1 },
         name: "pk_DetallePartida"
      }
   ]
});



```
