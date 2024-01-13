package dev.middlesand.starbie;

import dev.middlesand.starbie.configuration.ApplicationSettings;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Fusion extends Application {


    private static Stage theStage;

    public static Stage getStage()
    {
        return theStage;
    }

    private ApplicationSettings settings;

    @Override
    public void start(Stage stage) throws IOException {

        theStage = stage;
        String rootPath = System.getProperty("user.dir");

        this.settings = new ApplicationSettings(); // TODO load settings in

        if(settings.validSettings(rootPath))
        {
            settings.loadFromInitializedInstance(rootPath);
            FXMLLoader fxmlLoader = new FXMLLoader(Fusion.class.getResource("landing.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 600);
            scene.getStylesheets().add(getClass().getResource("themes/dark.css").toExternalForm());
            stage.setTitle("Fusion");
            stage.getIcons().add(new javafx.scene.image.Image(Fusion.class.getResourceAsStream("/images/testicon1.png")));
            stage.setScene(scene);
            stage.show();
            stage.setMaximized(true);
        }
        else
        {
            settings.initializeDirectories(rootPath);
            FXMLLoader fxmlLoader = new FXMLLoader(Fusion.class.getResource("welcome.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            scene.getStylesheets().add(getClass().getResource("themes/dark.css").toExternalForm());
            stage.setTitle("Fusion");
            stage.getIcons().add(new javafx.scene.image.Image(Fusion.class.getResourceAsStream("/images/testicon1.png")));
            stage.setScene(scene);
            stage.show();
        }

    }

    public static void main(String[] args) {
        initTray();
        launch();
    }

    public static void initTray()
    {
        //checking for support
        if(!SystemTray.isSupported()){
            System.out.println("System tray is not supported !!! ");
            return ;
        }
        //get the systemTray of the system
        SystemTray systemTray = SystemTray.getSystemTray();

        //get default toolkit
        //Toolkit toolkit = Toolkit.getDefaultToolkit();
        //get image
        //Toolkit.getDefaultToolkit().getImage("src/resources/busylogo.jpg");
        java.awt.Image image = Toolkit.getDefaultToolkit().getImage(Fusion.class.getResource("/images/testicon1.png"));

        //popupmenu
        PopupMenu trayPopupMenu = new PopupMenu();

        //1t menuitem for popupmenu
        MenuItem action = new MenuItem("Quit");
        action.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Quitting, saving first!");
                System.exit(0);
            }
        });
        trayPopupMenu.add(action);

        //2nd menuitem of popupmenu
        MenuItem close = new MenuItem("Close");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        trayPopupMenu.add(close);

        //setting tray icon
        TrayIcon trayIcon = new TrayIcon(image, "Fusion", trayPopupMenu);
        //adjust to default size as per system recommendation
        trayIcon.setImageAutoSize(true);

        try{
            systemTray.add(trayIcon);
        }catch(AWTException awtException){
            awtException.printStackTrace();
        }
    }
}