package Controller;

import Model.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class GameSystemAPI implements Serializable {

    private HashTable<GameMachine> gameMachineTable;
    private HashTable<Game> gameTable;
    private HashTable<GamePort> gamePortTable;

    public GameSystemAPI() {
        gameMachineTable = new HashTable<>();
        gameTable = new HashTable<>();
        gamePortTable = new HashTable<>();
    }

    //-------------------
    // Game Machine Handler
    //-------------------

    public boolean addGameMachine(String name, String manufacturer, String description, String type, String media, int launchYear, double price, String imageUrl) {
        // Check if a game machine with the same name already exists
        if (gameMachineTable.get(name.hashCode()) != null) {
            System.out.println("A game machine with the name " + name + " already exists.");
            return false;  // The game machine already exists, so return false
        }

        // Create a new GameMachine object with the provided details
        GameMachine newGameMachine = new GameMachine(name, manufacturer, description, type, media, launchYear, price, imageUrl);
        System.out.println("Created a new GameMachine: " + newGameMachine);

        // Add the new game machine to the hash table
        gameMachineTable.put(name.hashCode(), newGameMachine);
        System.out.println("Added the new GameMachine to the hash table.");

        return true;  // The game machine was successfully added, so return true
    }

    public HashTable<GameMachine> getGameMachines() {
        return gameMachineTable;
    }

    //-------------------
    // Game Handler
    //-------------------

    public boolean addGame(String title, String publisher, String description, String developer, String gameMachine, int releaseYear, String coverImageUrl) {
        // Check if a game with the same title already exists
        if (gameTable.get(title.hashCode()) != null) {
            System.out.println("A game with the title " + title + " already exists.");
            return false;  // The game already exists, so return false
        }

        // Create a new Game object with the provided details
        Game newGame = new Game(title, publisher, description, developer, gameMachine, releaseYear, coverImageUrl);
        System.out.println("Created a new Game: " + newGame);

        // Add the new game to the hash table
        gameTable.put(title.hashCode(), newGame);
        System.out.println("Added the new Game to the hash table.");

        return true;  // The game was successfully added, so return true
    }

    public HashTable<Game> getGames() {
        return gameTable;
    }

    //-------------------
    // Game Port Handler
    //-------------------

    public boolean addGamePort(Game originalGame, GameMachine portedGameMachine, String portDeveloper, int releaseYear, String coverImageUrl) {
        // Check if the release year is valid
        if (releaseYear < originalGame.getReleaseYear()) {
            System.out.println("Error: The release year of the ported game must be greater than or equal to the release year of the original game.");
            return false;  // The release year is not valid, so return false
        }

        // Check if a game port with the same original game and ported game machine already exists
        String key = originalGame.getTitle() + portedGameMachine.getName();
        if (gamePortTable.get(key.hashCode()) != null) {
            System.out.println("A game port with the original game " + originalGame.getTitle() + " and ported game machine " + portedGameMachine.getName() + " already exists.");
            return false;  // The game port already exists, so return false
        }

        // Create a new GamePort object with the provided details
        GamePort newGamePort = new GamePort(originalGame, portedGameMachine, portDeveloper, releaseYear, coverImageUrl);
        System.out.println("Created a new GamePort: " + newGamePort);

        // Add the new game port to the hash table
        gamePortTable.put(key.hashCode(), newGamePort);
        System.out.println("Added the new GamePort to the hash table.");

        return true;  // The game port was successfully added, so return true
    }

    public HashTable<GamePort> getGamePorts() {
        return gamePortTable;
    }

    //-------------------
    // System Data
    //-------------------

    /**
     * Saves the current state of the system to a file.
     * @param filename The name of the file where the data will be saved.
     */
    public void saveData(String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.println("Data saved successfully to " + filename);
        } catch (IOException i) {
            System.out.println("Error saving data: " + i.getMessage());
        }
    }

    /**
     * Loads the state of the system from a file.
     * @param filename The name of the file from which the data will be loaded.
     * @return A GameSystemAPI object containing the loaded data.
     */
    public static GameSystemAPI loadData(String filename) {
        GameSystemAPI api = null;
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            api = (GameSystemAPI) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Data loaded successfully from " + filename);
        } catch (IOException i) {
            System.out.println("Error loading data: " + i.getMessage());
        } catch (ClassNotFoundException c) {
            System.out.println("GameSystemAPI class not found");
        }
        return api;
    }
}
