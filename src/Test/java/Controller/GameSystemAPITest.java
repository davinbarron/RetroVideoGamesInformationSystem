package Controller;

import Model.Game;
import Model.GameMachine;
import Model.GamePort;
import Model.HashTable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameSystemAPITest {
    @Test
    void testAddGameMachine() {
        GameSystemAPI api = new GameSystemAPI();

        // Test adding a new game machine
        boolean result = api.addGameMachine("Test Machine", "Test Manufacturer", "Test Description", "Test Type", "Test Media", 2022, 499.99, "Test URL");
        assertTrue(result, "Failed to add a new game machine.");

        // Test adding a game machine with the same name
        result = api.addGameMachine("Test Machine", "Test Manufacturer", "Test Description", "Test Type", "Test Media", 2022, 499.99, "Test URL");
        assertFalse(result, "Should not be able to add a game machine with the same name.");
    }

    @Test
    void testGetGameMachines() {
        // Create a new GameSystemAPI
        GameSystemAPI api = new GameSystemAPI();

        // Define a game machine
        String name = "Game Machine 1";
        String manufacturer = "Manufacturer 1";
        String description = "Description 1";
        String type = "Type 1";
        String media = "Media 1";
        int launchYear = 2022;
        double price = 499.99;
        String imageUrl = "Image URL 1";

        // Add the game machine to the API
        api.addGameMachine(name, manufacturer, description, type, media, launchYear, price, imageUrl);

        // Get the game machines from the API
        HashTable<GameMachine> gameMachines = api.getGameMachines();

        // Assert that the game machines were retrieved successfully
        assertNotNull(gameMachines);
        assertEquals(1, gameMachines.size());
    }

    @Test
    void testAddGame() {
        GameSystemAPI api = new GameSystemAPI();

        // Test adding a new game
        boolean result = api.addGame("Test Game", "Test Publisher", "Test Description", "Test Developer", "Test Game Machine", 2022, "Test URL");
        assertTrue(result, "Failed to add a new game.");

        // Test adding a game with the same title
        result = api.addGame("Test Game", "Test Publisher", "Test Description", "Test Developer", "Test Game Machine", 2022, "Test URL");
        assertFalse(result, "Should not be able to add a game with the same title.");
    }

    @Test
    void testGetGames() {
        GameSystemAPI api = new GameSystemAPI();

        // Define a game
        String title = "Game 1";
        String publisher = "Publisher 1";
        String description = "Description 1";
        String developer = "Developer 1";
        String gameMachine = "Game Machine 1";
        int releaseYear = 2022;
        String coverImageUrl = "Image URL 1";

        // Add the game to the API
        api.addGame(title, publisher, description, developer, gameMachine, releaseYear, coverImageUrl);

        // Get the games from the API
        HashTable<Game> games = api.getGames();

        // Assert that the games were retrieved successfully
        assertNotNull(games);
        assertEquals(1, games.size());
    }

    @Test
    void testAddGamePort() {
        GameSystemAPI api = new GameSystemAPI();

        // Define a game and a game machine
        Game game = new Game("Test Game", "Test Publisher", "Test Description", "Test Developer", "Test Game Machine", 2022, "Test URL");
        GameMachine gameMachine = new GameMachine("Test Machine", "Test Manufacturer", "Test Description", "Test Type", "Test Media", 2022, 499.99, "Test URL");

        // Test adding a new game port
        boolean result = api.addGamePort(game, gameMachine, "Test Port Developer", 2023, "Test URL");
        assertTrue(result, "Failed to add a new game port.");

        // Test adding a game port with the same original game and ported game machine
        result = api.addGamePort(game, gameMachine, "Test Port Developer", 2023, "Test URL");
        assertFalse(result, "Should not be able to add a game port with the same original game and ported game machine.");
    }

    @Test
    void testGetGamePorts() {
        GameSystemAPI api = new GameSystemAPI();

        // Define a game and a game machine
        Game game = new Game("Test Game", "Test Publisher", "Test Description", "Test Developer", "Test Game Machine", 2022, "Test URL");
        GameMachine gameMachine = new GameMachine("Test Machine", "Test Manufacturer", "Test Description", "Test Type", "Test Media", 2022, 499.99, "Test URL");

        // Add a game port to the API
        api.addGamePort(game, gameMachine, "Test Port Developer", 2023, "Test URL");

        // Get the game ports from the API
        HashTable<GamePort> gamePorts = api.getGamePorts();

        // Assert that the game ports were retrieved successfully
        assertNotNull(gamePorts);
        assertEquals(1, gamePorts.size());
    }

    @Test
    void testSaveAndLoadData() {
        GameSystemAPI api = new GameSystemAPI();

        // Add a game machine to the API
        api.addGameMachine("Test Machine", "Test Manufacturer", "Test Description", "Test Type", "Test Media", 2022, 499.99, "Test URL");

        // Save the data to a file
        api.saveData("testfile");

        // Load the data from the file
        GameSystemAPI loadedApi = GameSystemAPI.loadData("testfile");

        // Assert that the loaded data matches the saved data
        assertNotNull(loadedApi);
        assertEquals(api.getGameMachines().size(), loadedApi.getGameMachines().size());
    }

}
