package Application;

import Controller.GameSystemAPI;
import Model.GameMachine;
import Model.HashTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.Serializable;

public class GameMachineMenu implements Serializable {
    @FXML
    private TableView<GameMachine> gameMachineTable;
    @FXML
    private TextField nameField;
    @FXML
    private TextField manufacturerField;
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField typeField;
    @FXML
    private TextField mediaField;
    @FXML
    private TextField launchYearField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField imageUrlField;
    @FXML
    private Button addButton;

    GameSystemAPI instance = GameSystemAPIInstance.getInstance();

    public void initialize() {
        // Create columns for the TableView
        TableColumn<GameMachine, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<GameMachine, String> manufacturerColumn = new TableColumn<>("Manufacturer");
        manufacturerColumn.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));

        TableColumn<GameMachine, String> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<GameMachine, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<GameMachine, String> mediaColumn = new TableColumn<>("Media");
        mediaColumn.setCellValueFactory(new PropertyValueFactory<>("media"));

        TableColumn<GameMachine, Integer> launchYearColumn = new TableColumn<>("Launch Year");
        launchYearColumn.setCellValueFactory(new PropertyValueFactory<>("launchYear"));

        TableColumn<GameMachine, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<GameMachine, String> imageUrlColumn = new TableColumn<>("Image URL");
        imageUrlColumn.setCellValueFactory(new PropertyValueFactory<>("imageUrl"));

        // Add the columns to the TableView
        gameMachineTable.getColumns().addAll(nameColumn, manufacturerColumn, descriptionColumn, typeColumn, mediaColumn, launchYearColumn, priceColumn, imageUrlColumn);

        // Load the data into the table
        updateTable();
    }

    @FXML
    protected void addGameMachine() {
        // Create a new GameMachine object with the entered details
        GameMachine newGameMachine = new GameMachine(
                nameField.getText(),
                manufacturerField.getText(),
                descriptionField.getText(),
                typeField.getText(),
                mediaField.getText(),
                Integer.parseInt(launchYearField.getText()),
                Double.parseDouble(priceField.getText()),
                imageUrlField.getText()
        );

        // Add the new game machine to the system using the GameSystemAPI
        boolean isAdded = instance.addGameMachine(
                newGameMachine.getName(),
                newGameMachine.getManufacturer(),
                newGameMachine.getDescription(),
                newGameMachine.getType(),
                newGameMachine.getMedia(),
                newGameMachine.getLaunchYear(),
                newGameMachine.getPrice(),
                newGameMachine.getImageUrl()
        );


        if (isAdded) {
            // Clear the text fields
            nameField.clear();
            manufacturerField.clear();
            descriptionField.clear();
            typeField.clear();
            mediaField.clear();
            launchYearField.clear();
            priceField.clear();
            imageUrlField.clear();

            // Update the table
            updateTable();
        } else {
            // Show an error message
            System.out.println("Error: The game machine could not be added.");
        }
    }

    private void updateTable() {
        // Get the list of game machines from the GameSystemAPI
        HashTable<GameMachine> gameMachineHashTable = instance.getGameMachines();

        // Print out the contents of the HashTable
        System.out.println("HashTable contents: " + gameMachineHashTable);

        // Create an empty ObservableList
        ObservableList<GameMachine> observableList = FXCollections.observableArrayList();

        // Get the values from the HashTable
        Object[] gameMachines = gameMachineHashTable.values();
        for (int i = 0; i < gameMachines.length; i++) {
            GameMachine gameMachine = (GameMachine) gameMachines[i];
            observableList.add(gameMachine);

            // Print out the game machine being added
            System.out.println("Adding game machine to ObservableList: " + gameMachine);
        }

        // Print out the contents of the ObservableList
        System.out.println("ObservableList contents: " + observableList);

        // Set the ObservableList as the items of the TableView
        gameMachineTable.setItems(observableList);

        // Print out the items in the TableView
        System.out.println("TableView items: " + gameMachineTable.getItems());
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
