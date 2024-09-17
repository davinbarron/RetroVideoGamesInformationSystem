package Application;

import Model.Game;
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

public class GameMenu implements Serializable {
    @FXML
    private TableView<Game> gameTable;
    @FXML
    private TextField titleField;
    @FXML
    private TextField publisherField;
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField developerField;
    @FXML
    private TextField gameMachineField;
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
        TableColumn<Game, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Game, String> publisherColumn = new TableColumn<>("Publisher");
        publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));

        TableColumn<Game, String> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Game, String> developerColumn = new TableColumn<>("Developer");
        developerColumn.setCellValueFactory(new PropertyValueFactory<>("developer"));

        TableColumn<Game, String> gameMachineColumn = new TableColumn<>("Game Machine");
        gameMachineColumn.setCellValueFactory(new PropertyValueFactory<>("gameMachine"));

        TableColumn<Game, Integer> releaseYearColumn = new TableColumn<>("Release Year");
        releaseYearColumn.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));

        TableColumn<Game, String> coverImageUrlColumn = new TableColumn<>("Cover Image URL");
        coverImageUrlColumn.setCellValueFactory(new PropertyValueFactory<>("coverImageUrl"));

        // Add the columns to the TableView
        gameTable.getColumns().addAll(titleColumn, publisherColumn, descriptionColumn, developerColumn, gameMachineColumn, releaseYearColumn, coverImageUrlColumn);

        // Load the data into the table
        updateTable();
    }

    @FXML
    protected void addGame() {
        // Create a new Game object with the entered details
        Game newGame = new Game(
                titleField.getText(),
                publisherField.getText(),
                descriptionField.getText(),
                developerField.getText(),
                gameMachineField.getText(),
                Integer.parseInt(releaseYearField.getText()),
                coverImageUrlField.getText()
        );

        // Add the new game to the system using the GameSystemAPI
        boolean isAdded = instance.addGame(
                newGame.getTitle(),
                newGame.getPublisher(),
                newGame.getDescription(),
                newGame.getDeveloper(),
                newGame.getGameMachine(),
                newGame.getReleaseYear(),
                newGame.getCoverImageUrl()
        );

        if (isAdded) {
            // Clear the text fields
            titleField.clear();
            publisherField.clear();
            descriptionField.clear();
            developerField.clear();
            gameMachineField.clear();
            releaseYearField.clear();
            coverImageUrlField.clear();

            // Update the table
            updateTable();
        } else {
            // Show an error message
            System.out.println("Error: The game could not be added.");
        }
    }

    private void updateTable() {
        // Get the list of games from the GameSystemAPI
        HashTable<Game> gameHashTable = instance.getGames();

        // Print out the contents of the HashTable
        System.out.println("HashTable contents: " + gameHashTable);

        // Create an empty ObservableList
        ObservableList<Game> observableList = FXCollections.observableArrayList();

        // Get the values from the HashTable
        Object[] games = gameHashTable.values();
        for (int i = 0; i < games.length; i++) {
            Game game = (Game) games[i];
            observableList.add(game);

            // Print out the game being added
            System.out.println("Adding game to ObservableList: " + game);
        }

        // Print out the contents of the ObservableList
        System.out.println("ObservableList contents: " + observableList);

        // Set the ObservableList as the items of the TableView
        gameTable.setItems(observableList);

        // Print out the items in the TableView
        System.out.println("TableView items: " + gameTable.getItems());
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
