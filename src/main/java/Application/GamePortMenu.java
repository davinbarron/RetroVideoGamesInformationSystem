package Application;

import Model.Game;
import Model.GameMachine;
import Model.GamePort;
import Controller.GameSystemAPI;
import Model.HashTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.Serializable;

public class GamePortMenu implements Serializable {
    @FXML
    private TableView<GamePort> gamePortTable;
    @FXML
    private TextField originalGameField;
    @FXML
    private TextField portedGameMachineField;
    @FXML
    private TextField portDeveloperField;
    @FXML
    private TextField releaseYearField;
    @FXML
    private TextField coverImageUrlField;

    @FXML
    private Button addButton;

    GameSystemAPI instance = GameSystemAPIInstance.getInstance();

    @FXML
    protected void initialize() {
        // Create columns for the TableView
        TableColumn<GamePort, Game> originalGameColumn = new TableColumn<>("Original Game");
        originalGameColumn.setCellValueFactory(new PropertyValueFactory<>("originalGame"));

        TableColumn<GamePort, GameMachine> portedGameMachineColumn = new TableColumn<>("Ported Game Machine");
        portedGameMachineColumn.setCellValueFactory(new PropertyValueFactory<>("portedGameMachine"));

        TableColumn<GamePort, String> portDeveloperColumn = new TableColumn<>("Port Developer");
        portDeveloperColumn.setCellValueFactory(new PropertyValueFactory<>("portDeveloper"));

        TableColumn<GamePort, Integer> releaseYearColumn = new TableColumn<>("Release Year");
        releaseYearColumn.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));

        TableColumn<GamePort, String> coverImageUrlColumn = new TableColumn<>("Cover Image URL");
        coverImageUrlColumn.setCellValueFactory(new PropertyValueFactory<>("coverImageUrl"));

        // Add the columns to the TableView
        gamePortTable.getColumns().addAll(originalGameColumn, portedGameMachineColumn, portDeveloperColumn, releaseYearColumn, coverImageUrlColumn);

        // Load the data into the table
        updateTable();
    }

    @FXML
    protected void addGamePort() {
        // Retrieve the originalGame and portedGameMachine objects from their respective tables
        String originalGameTitle = originalGameField.getText();
        Game originalGame = instance.getGames().get(originalGameTitle.hashCode());

        String portedGameMachineName = portedGameMachineField.getText();
        GameMachine portedGameMachine = instance.getGameMachines().get(portedGameMachineName.hashCode());

        // Check if the originalGame and portedGameMachine exist
        if (originalGame == null) {
            System.out.println("Error: The game " + originalGameTitle + " does not exist.");
            return;
        }
        if (portedGameMachine == null) {
            System.out.println("Error: The game machine " + portedGameMachineName + " does not exist.");
            return;
        }

        // Create a new GamePort object with the retrieved details
        GamePort newGamePort = new GamePort(
                originalGame,
                portedGameMachine,
                portDeveloperField.getText(),
                Integer.parseInt(releaseYearField.getText()),
                coverImageUrlField.getText()
        );

        // Add the new game port to the system using the GameSystemAPI
        boolean isAdded = instance.addGamePort(
                newGamePort.getOriginalGame(),
                newGamePort.getPortedGameMachine(),
                newGamePort.getPortDeveloper(),
                newGamePort.getReleaseYear(),
                newGamePort.getCoverImageUrl()
        );

        if (isAdded) {
            // Clear the text fields
            originalGameField.clear();
            portedGameMachineField.clear();
            portDeveloperField.clear();
            releaseYearField.clear();
            coverImageUrlField.clear();

            // Update the table
            updateTable();
        } else {
            // Show an error message
            System.out.println("Error: The game port could not be added.");
        }
    }


    private void updateTable() {
        // Get the list of game ports from the GameSystemAPI
        HashTable<GamePort> gamePortHashTable = instance.getGamePorts();

        // Print out the contents of the HashTable
        System.out.println("HashTable contents: " + gamePortHashTable);

        // Create an empty ObservableList
        ObservableList<GamePort> observableList = FXCollections.observableArrayList();

        // Get the values from the HashTable
        Object[] gamePorts = gamePortHashTable.values();
        for (int i = 0; i < gamePorts.length; i++) {
            GamePort gamePort = (GamePort) gamePorts[i];
            observableList.add(gamePort);

            // Print out the game port being added
            System.out.println("Adding game port to ObservableList: " + gamePort);
        }

        // Print out the contents of the ObservableList
        System.out.println("ObservableList contents: " + observableList);

        // Set the ObservableList as the items of the TableView
        gamePortTable.setItems(observableList);

        // Print out the items in the TableView
        System.out.println("TableView items: " + gamePortTable.getItems());
    }


    @FXML
    protected void buttonHover(MouseEvent event) {
        Button button = (Button) event.getSource();
        button.setStyle(button.getStyle() + "-fx-background-color: #3aa3a0;");
    }

    @FXML
    protected void buttonExit(MouseEvent event) {
        Button button = (Button) event.getSource();
        String originalColor = button.getText().equals("Remove Pallet") ? "#8930cf" : "#d01212";
        button.setStyle(button.getStyle().replace("-fx-background-color: #3aa3a0;", "-fx-background-color: " + originalColor + ";"));
    }

    @FXML
    protected void buttonPress(MouseEvent event) {
        Button button = (Button) event.getSource();
        button.setStyle(button.getStyle() + "-fx-background-color: #f67de5;");
    }

    @FXML
    protected void buttonRelease(MouseEvent event) {
        Button button = (Button) event.getSource();
        String originalColor = button.getText().equals("Remove Pallet") ? "#8930cf" : "#d01212";
        button.setStyle(button.getStyle().replace("-fx-background-color: #f67de5;", "-fx-background-color: " + originalColor + ";"));
    }
}
