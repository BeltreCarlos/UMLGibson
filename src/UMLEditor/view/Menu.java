/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UMLEditor.view;

import UMLEditor.Main;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


import java.util.Optional;

/**
 *
 * @author pslandis
 */
public class Menu {
    // parent instance
    private final Main main;
    
    public javafx.scene.control.MenuBar bar;
    private UmlView view = new UmlView();

    //File Buttons
    private javafx.scene.control.Menu fileMenu;
    private javafx.scene.control.MenuItem newMenuItem;
    private javafx.scene.control.MenuItem saveMenuItem;
    private javafx.scene.control.MenuItem exitMenuItem;

    private MediaPlayer mediaPlayer;

    //Tool Buttons
    javafx.scene.control.Menu toolMenu;
    javafx.scene.control.MenuItem toggleTools;

    //Gibson Buttons
    private javafx.scene.control.Menu gibsonMenu;
    private javafx.scene.control.MenuItem activateGibson;


    //****************************************************************************

    private String gibson_background = "-fx-background-color: #A9A9A9; " +
            "-fx-background-image: url('UMLEditor/view/images/braveheart_bkg.png'); " +
            "-fx-background-position: center center; " +
            "-fx-background-size: cover;";
    //****************************************************************************
    
    public Menu(Main main){
        this.main = main;
        
        this.bar = new javafx.scene.control.MenuBar();
        //this.bar.prefWidthProperty().bind(this.main.stage.widthProperty());
        bar.useSystemMenuBarProperty().set(true);

        //main.bp.setTop(this.bar);
        this.main.layout.setTop(this.bar);

        // File menu - new, save, exit
        fileMenu = new javafx.scene.control.Menu("File");
        newMenuItem = new javafx.scene.control.MenuItem("New");
        saveMenuItem = new javafx.scene.control.MenuItem("Save");
        exitMenuItem = new javafx.scene.control.MenuItem("Exit");
        exitMenuItem.setOnAction((event) -> {
            System.exit(0);
        });

        //Tools Menu
        toolMenu = new javafx.scene.control.Menu("Tools");
        toggleTools = new javafx.scene.control.MenuItem("Toggle toolbox");

        //Gibson Mode Menu
        gibsonMenu = new javafx.scene.control.Menu("GibsonMode");
        activateGibson = new javafx.scene.control.MenuItem("Activate Gibson Mode");

        //****************************************************************************
        activateGibson.setOnAction((event) -> {
            createAlert();
        });
        //****************************************************************************

        fileMenu.getItems().addAll(newMenuItem, saveMenuItem,
        new SeparatorMenuItem(), exitMenuItem);
        toolMenu.getItems().add(toggleTools);
        gibsonMenu.getItems().addAll(activateGibson);
        this.bar.getMenus().addAll(fileMenu, toolMenu, gibsonMenu);
    }

    public MenuItem getGibsonButton(){
        return activateGibson;
    }

    //****************************************************************************
    public Alert createAlert(){
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Activating Gibson Mode...");
        alert1.setHeaderText("WARNING: You are about to activate Gibson Mode");
        alert1.setContentText("Activating Gibson Mode is the point of no return. Are you sure" +
                " you want to do this?");
        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert2.setTitle("Activating Gibson Mode...");
        alert2.setHeaderText("ARE YOU SURE???");
        alert2.setContentText("If you do this, you'll have to close the app to exit it!");

        Alert alert3 = new Alert(Alert.AlertType.CONFIRMATION);
        alert3.setTitle("Activating Gibson Mode...");
        alert3.setHeaderText("Alright! Relax!");
        alert3.setContentText("Can't say I didn't warn you. Good luck out there!");

        // *******

        // *******

        Optional<ButtonType> result = alert1.showAndWait();
        if(result.get() == ButtonType.OK)
        {
            System.out.println("Confirm 1 Accepted");
            main.updateBackground(gibson_background);

            // Media File and Player
            Media mediaFile = new Media("file:///Users/beltre/develop/UMLGibson/src/UMLEditor/resources/StopCrying.wav");
            mediaPlayer = new MediaPlayer(mediaFile);
            mediaPlayer.play();

//            Optional<ButtonType> result2 = alert2.showAndWait();
//            if(result2.get() == ButtonType.OK)
//            {
//                System.out.println("Confirm 2 Accepted");
//                Optional<ButtonType> result3 = alert3.showAndWait();
//                if(result3.get() == ButtonType.OK) {
//                    System.out.println("Confirm 3 Accepted");
//                }else {
//                    System.out.println("Confirm 3 Denied");
//                }
//
//            }else {
//                System.out.println("Confirm 2 Denied");
//            }

        }else{
            System.out.println("Confirm 1 Denied");
        }

        return alert1;
    }

    //****************************************************************************
}
