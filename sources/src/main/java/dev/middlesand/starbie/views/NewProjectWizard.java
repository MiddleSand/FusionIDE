package dev.middlesand.starbie.views;

import dev.middlesand.starbie.projects.Project;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import dev.middlesand.starbie.Fusion;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewProjectWizard
{
    @FXML private ChoiceBox choiceBox;
    @FXML private TextField name;

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("Basic", "Not Basic");
        //populate the Choicebox;
        choiceBox.setItems(list);

    }

    private static void configureFileChooser(final FileChooser fileChooser, String title){
        fileChooser.setTitle(title);
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.dir"))
        );
    }
    private static void configureDirectoryChooser(final DirectoryChooser directoryChooser, String title){
        directoryChooser.setTitle(title);
        directoryChooser.setInitialDirectory(
                new File(System.getProperty("user.dir") + "/projects/")
        );
    }

    @FXML
    protected void onPickRootDirectory()
    {
        File root = null;

        DirectoryChooser directoryChooser = new DirectoryChooser();
        configureDirectoryChooser(directoryChooser, "Choose Root Directory");
        root = directoryChooser.showDialog(Fusion.getStage());

        try
        {
            Project project = new Project(root.getAbsolutePath() + "/" + this.name.textProperty().getValue(), this.choiceBox.getValue().toString(), this.name.textProperty().getValue());
            if(project == null)
            {
                // report error and try again
            }
            else
            {
                Window window = name.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(Fusion.class.getResource("main-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                scene.getStylesheets().add(Fusion.class.getResource("themes/dark.css").toExternalForm());
                Fusion.getStage().setTitle(project.getName());
                Fusion.getStage().getIcons().add(new javafx.scene.image.Image(Fusion.class.getResourceAsStream("/images/testicon1.png")));
                Fusion.getStage().setScene(scene);
                window.hide();
                Fusion.getStage().setMaximized(false);
                Fusion.getStage().show();
                Fusion.getStage().setMaximized(true);

            }
        }
        catch (IOException e)
        {
            // Handle error or something idk i just work here lololololololololololol.ol TODO
        }

    }
}
