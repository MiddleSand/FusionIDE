package dev.middlesand.starbie.views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.stage.FileChooser;
import dev.middlesand.starbie.Fusion;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class NewProjectWizard
{

    @FXML private ChoiceBox choiceBox;

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("Basic");
        //populate the Choicebox;
        choiceBox.setItems(list);

    }

    private static void configureFileChooser(final FileChooser fileChooser, String title){
        fileChooser.setTitle(title);
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
    }

    @FXML
    protected void onPickRootDirectory()
    {
        FileChooser fileChooser = new FileChooser();
        configureFileChooser(fileChooser, "Choose Root Directory");
        fileChooser.showOpenDialog(Fusion.getStage());
    }
}
