package com.example.juegoadivina;

import com.mongodb.MongoException;
import com.mongodb.client.*;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import org.bson.Document;


public class MongoCon {

    protected static final String CONNECTION_STRING = "mongodb://localhost:27017";
    protected static final String DATABASE_NAME = "mydb";

    protected MongoClient mongoClient;
    protected MongoDatabase database;
    protected static MongoCollection<Document> jugadorCollection;
    protected MongoCollection<Document> partidaCollection;
    protected MongoCollection<Document> detallePartidaCollection;

    public MongoCon() {
        mongoClient = MongoClients.create(CONNECTION_STRING);
        database = mongoClient.getDatabase(DATABASE_NAME);
        jugadorCollection = database.getCollection("Jugador");
        partidaCollection = database.getCollection("Partida");
        detallePartidaCollection = database.getCollection("DetallePartida");
    }

    /**
     * Checks if the provided username and password are valid for a user.
     *
     * @param nombre   The username to validate.
     * @param password The password to validate.
     * @return A Jugador object if the username and password are valid, or null if the username or password are incorrect or the user doesn't exist.
     */
    public static Jugador isUserPassValid(String nombre, String password) {
        Document query = new Document("nombre", nombre).append("contrasena", password);
        FindIterable<Document> result = jugadorCollection.find(query);

        MongoCursor<Document> cursor = result.iterator();
        if (cursor.hasNext()) {
            Document document = cursor.next();
            try {
                Jugador jugador = new Jugador(
                        document.getInteger("ranking"),
                        document.getString("nombre"),
                        document.getString("email"),
                        document.getString("contrasena"),
                        document.getInteger("partidasJugadas"),
                        document.getInteger("partidasGanadas"),
                        document.getInteger("puntos")
                );
                cursor.close();
                return jugador;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        cursor.close();
        return null;
    }

    /*
    * The method takes two parameters: nombre (username) and email.
    * Two separate query documents are created: one to check if the nombre exists and another to check if the email exists.
    * The countDocuments method is used on jugadorCollection with the respective query documents to count the number of matching documents.
    * The method checks if both the nombreCount and emailCount are equal to 0. If so, it means that neither the nombre nor the email exists in the database, and the method returns true.
    * Otherwise, if either count is greater than 0, it means that the nombre or email already exists in the database, and the method returns false.
    * */
    public static boolean isNombreEmailAvailable(String nombre, String email) {
        //return false if the user exist. true if not exist
        Document nombreQuery = new Document("nombre", nombre);
        Document emailQuery = new Document("email", email);

        long nombreCount = jugadorCollection.countDocuments(nombreQuery);
        long emailCount = jugadorCollection.countDocuments(emailQuery);

        return nombreCount == 0 && emailCount == 0;
    }

    /**
     * Retrieves the rank of the player with the highest ranking from the "Jugador" collection.
     *
     * @return The rank of the player with the highest ranking, or -1 if the collection is empty.
     */
    public static int getLatestRank() {
        // get the last rank -> to make every new Jugador has the lastRank +1
        FindIterable<Document> result = jugadorCollection.find()
                .sort(Sorts.descending("ranking"))
                .projection(Projections.include("ranking"))
                .limit(1);

        MongoCursor<Document> cursor = result.iterator();
        if (cursor.hasNext()) {
            Document document = cursor.next();
            int latestRank = document.getInteger("ranking");
            cursor.close();
            return latestRank;
        } else {
            cursor.close();
            return -1;
        }
    }

    /**
     * Inserts a new player into the "Jugador" collection.
     *
     * @param jugador The Jugador object representing the player to be inserted.
     * @return True if the player is successfully inserted, false otherwise.
     */
    public static boolean signUp(Jugador jugador) {
        Document jugadorDoc = new Document()
                .append("ranking", jugador.getRanking())
                .append("nombre", jugador.getNombre())
                .append("contrasena", jugador.getPassword())
                .append("email", jugador.getEmail())
                .append("puntos", jugador.getPuntos())
                .append("partidasJugadas", jugador.getPartidasJugadas())
                .append("partidasGanadas", jugador.getPartidasGanadas());

        try {
            jugadorCollection.insertOne(jugadorDoc);
            return true;
        } catch (MongoException e) {
            e.printStackTrace();
            return false;
        }
    }


    // Rest of the methods...

    public void close() {
        // Close the MongoDB client and any other resources
        database = null;
    }
}