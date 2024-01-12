package dev.middlesand.starbie.views;

import dev.middlesand.starbie.Fusion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class LandingScreen {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onClickAboutButton() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void onCreateNewProject(ActionEvent actionEvent) throws IOException {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(Fusion.getStage());
        FXMLLoader fxmlLoader = new FXMLLoader(Fusion.class.getResource("new-project-wizard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        scene.getStylesheets().add(Fusion.class.getResource("themes/dark.css").toExternalForm());
        dialog.setTitle("Create New Project");
        dialog.getIcons().add(new javafx.scene.image.Image(Fusion.class.getResourceAsStream("/images/testicon1.png")));
        dialog.setScene(scene);
        dialog.show();
    }
}