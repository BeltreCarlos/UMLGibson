/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UMLEditor.view;

import UMLEditor.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static java.awt.SystemColor.desktop;

/**
 *
 * @author pslandis
 */
public class Menu {
    // parent instance
    private final Main main;

    public javafx.scene.control.MenuBar bar;

    public Menu(Main main){
        this.main = main;

        this.bar = new MenuBar();
        this.bar.prefWidthProperty().bind(this.main.stage.widthProperty());

        //main.bp.setTop(this.bar);
        this.main.layout.setTop(this.bar);

        // File menu - new, save, exit
        javafx.scene.control.Menu fileMenu = new javafx.scene.control.Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        MenuItem saveMenuItem = new MenuItem("Save");
        MenuItem exitMenuItem = new MenuItem("Exit");
        //exitMenuItem.setOnAction(actionEvent -> Platform.exit());

        javafx.scene.control.Menu toolMenu = new javafx.scene.control.Menu("Tools");
        MenuItem toggleTools = new MenuItem("Toggle toolbox");

        javafx.scene.control.Menu helpMenu = new javafx.scene.control.Menu("Help");
        MenuItem helpMenuItem = new MenuItem("Help");
        helpMenuItem.setOnAction(actionEvent -> {
            try {
                openHelp();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        MenuItem aboutMenuItem = new MenuItem("About");
        aboutMenuItem.setOnAction(actionEvent -> showAbout());


        fileMenu.getItems().addAll(newMenuItem, saveMenuItem,
        new SeparatorMenuItem(), exitMenuItem);
        toolMenu.getItems().add(toggleTools);
        helpMenu.getItems().addAll(helpMenuItem, aboutMenuItem);
        this.bar.getMenus().addAll(fileMenu, toolMenu, helpMenu);
    }

    // Help methods here; could use some reorganization?

    /**
     * Opens help.txt if it's there... It should be there.
     *
     * @author  Joseph Asbury
     * @version 1.0
     * @throws IOException
     */
    public void openHelp() throws IOException {
        File file = new File("help.txt");
        Desktop desktop = Desktop.getDesktop();
        if (!file.exists()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Help file not found");
            alert.setHeaderText(null);
            alert.setContentText("The help file is missing.");
            alert.showAndWait();
        } else desktop.open(file);
    }

    /**
     * "About" dialog box.
     *
     * @author  Joseph Asbury
     * @version 1.0
     */
    public void showAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText(null);
        alert.setContentText("UMLGibson, Iteration 2. A clean UML diagram editor brought to you by The Slackers. This software is currently in development.");
        alert.showAndWait();
    }
}
