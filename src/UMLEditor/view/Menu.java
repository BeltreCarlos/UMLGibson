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


    //Tool Buttons
    javafx.scene.control.Menu toolMenu;
    javafx.scene.control.MenuItem toggleTools;
    
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

        fileMenu.getItems().addAll(newMenuItem, saveMenuItem,
        new SeparatorMenuItem(), exitMenuItem);
        toolMenu.getItems().add(toggleTools);
        this.bar.getMenus().addAll(fileMenu, toolMenu);
    }


}
