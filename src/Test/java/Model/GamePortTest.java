package Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GamePortTest {
    @Test
    void testGamePort() {
        // Create a new Game and GameMachine object
        Game originalGame = new Game("Test Game", "Test Publisher", "Test Description", "Test Developer", "Test GameMachine", 2022, "Test URL");
        GameMachine portedGameMachine = new GameMachine("Test Machine", "Test Manufacturer", "Test Description", "Test Type", "Test Media", 2022, 499.99, "Test URL");

        // Create a new GamePort object
        GamePort gamePort = new GamePort(originalGame, portedGameMachine, "Test Port Developer", 2023, "Test Port URL");

        // Test the getter methods
        assertEquals(originalGame, gamePort.getOriginalGame(), "Failed to get the correct original game.");
        assertEquals(portedGameMachine, gamePort.getPortedGameMachine(), "Failed to get the correct ported game machine.");
        assertEquals("Test Port Developer", gamePort.getPortDeveloper(), "Failed to get the correct port developer.");
        assertEquals(2023, gamePort.getReleaseYear(), "Failed to get the correct release year.");
        assertEquals("Test Port URL", gamePort.getCoverImageUrl(), "Failed to get the correct cover image URL.");

        // Test the setter methods
        Game newOriginalGame = new Game("New Game", "New Publisher", "New Description", "New Developer", "New GameMachine", 2023, "New URL");
        gamePort.setOriginalGame(newOriginalGame);
        assertEquals(newOriginalGame, gamePort.getOriginalGame(), "Failed to set the correct original game.");

        GameMachine newPortedGameMachine = new GameMachine("New Machine", "New Manufacturer", "New Description", "New Type", "New Media", 2023, 599.99, "New URL");
        gamePort.setPortedGameMachine(newPortedGameMachine);
        assertEquals(newPortedGameMachine, gamePort.getPortedGameMachine(), "Failed to set the correct ported game machine.");

        gamePort.setPortDeveloper("New Port Developer");
        assertEquals("New Port Developer", gamePort.getPortDeveloper(), "Failed to set the correct port developer.");

        gamePort.setReleaseYear(2024);
        assertEquals(2024, gamePort.getReleaseYear(), "Failed to set the correct release year.");

        gamePort.setCoverImageUrl("New Port URL");
        assertEquals("New Port URL", gamePort.getCoverImageUrl(), "Failed to set the correct cover image URL.");
    }
}

