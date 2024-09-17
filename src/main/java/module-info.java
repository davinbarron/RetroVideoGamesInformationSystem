module g.retrovideogamesinformationsystem {
    requires javafx.controls;
    requires javafx.fxml;

    opens Model to javafx.base;
    opens Application to javafx.fxml;
    exports Application;
}