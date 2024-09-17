package Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameMachineTest {
    @Test
    void testGameMachine() {
        // Create a new GameMachine object
        GameMachine gameMachine = new GameMachine("Test Machine", "Test Manufacturer", "Test Description", "Test Type", "Test Media", 2022, 499.99, "Test URL");

        // Test the getter methods
        assertEquals("Test Machine", gameMachine.getName(), "Failed to get the correct name.");
        assertEquals("Test Manufacturer", gameMachine.getManufacturer(), "Failed to get the correct manufacturer.");
        assertEquals("Test Description", gameMachine.getDescription(), "Failed to get the correct description.");
        assertEquals("Test Type", gameMachine.getType(), "Failed to get the correct type.");
        assertEquals("Test Media", gameMachine.getMedia(), "Failed to get the correct media.");
        assertEquals(2022, gameMachine.getLaunchYear(), "Failed to get the correct launch year.");
        assertEquals(499.99, gameMachine.getPrice(), 0.01, "Failed to get the correct price.");
        assertEquals("Test URL", gameMachine.getImageUrl(), "Failed to get the correct image URL.");

        // Test the setter methods
        gameMachine.setName("New Name");
        assertEquals("New Name", gameMachine.getName(), "Failed to set the correct name.");

        gameMachine.setManufacturer("New Manufacturer");
        assertEquals("New Manufacturer", gameMachine.getManufacturer(), "Failed to set the correct manufacturer.");

        gameMachine.setDescription("New Description");
        assertEquals("New Description", gameMachine.getDescription(), "Failed to set the correct description.");

        gameMachine.setType("New Type");
        assertEquals("New Type", gameMachine.getType(), "Failed to set the correct type.");

        gameMachine.setMedia("New Media");
        assertEquals("New Media", gameMachine.getMedia(), "Failed to set the correct media.");

        gameMachine.setLaunchYear(2023);
        assertEquals(2023, gameMachine.getLaunchYear(), "Failed to set the correct launch year.");

        gameMachine.setPrice(599.99);
        assertEquals(599.99, gameMachine.getPrice(), 0.01, "Failed to set the correct price.");

        gameMachine.setImageUrl("New URL");
        assertEquals("New URL", gameMachine.getImageUrl(), "Failed to set the correct image URL.");
    }
}

