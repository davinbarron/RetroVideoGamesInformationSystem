package Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void testGame() {
        // Create a new Game object
        Game game = new Game("Test Game", "Test Publisher", "Test Description", "Test Developer", "Test GameMachine", 2022, "Test URL");

        // Test the getter methods
        assertEquals("Test Game", game.getTitle(), "Failed to get the correct title.");
        assertEquals("Test Publisher", game.getPublisher(), "Failed to get the correct publisher.");
        assertEquals("Test Description", game.getDescription(), "Failed to get the correct description.");
        assertEquals("Test Developer", game.getDeveloper(), "Failed to get the correct developer.");
        assertEquals("Test GameMachine", game.getGameMachine(), "Failed to get the correct game machine.");
        assertEquals(2022, game.getReleaseYear(), "Failed to get the correct release year.");
        assertEquals("Test URL", game.getCoverImageUrl(), "Failed to get the correct cover image URL.");

        // Test the setter methods
        game.setTitle("New Title");
        assertEquals("New Title", game.getTitle(), "Failed to set the correct title.");

        game.setPublisher("New Publisher");
        assertEquals("New Publisher", game.getPublisher(), "Failed to set the correct publisher.");

        game.setDescription("New Description");
        assertEquals("New Description", game.getDescription(), "Failed to set the correct description.");

        game.setDeveloper("New Developer");
        assertEquals("New Developer", game.getDeveloper(), "Failed to set the correct developer.");

        game.setGameMachine("New GameMachine");
        assertEquals("New GameMachine", game.getGameMachine(), "Failed to set the correct game machine.");

        game.setReleaseYear(2023);
        assertEquals(2023, game.getReleaseYear(), "Failed to set the correct release year.");

        game.setCoverImageUrl("New URL");
        assertEquals("New URL", game.getCoverImageUrl(), "Failed to set the correct cover image URL.");
    }
}
