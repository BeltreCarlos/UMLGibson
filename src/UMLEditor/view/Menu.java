/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UMLEditor.view;

import UMLEditor.Main;
import UMLEditor.controller.UmlController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.SeparatorMenuItem;

/**
 *
 * @author pslandis
 */
public class Menu {
    // parent instance
    private final Main main;
    
    public javafx.scene.control.MenuBar bar;
    public javafx.scene.control.CheckMenuItem toggleToolbox;
    
    public Menu(Main main){
        this.main = main;
        
        
        this.bar = new javafx.scene.control.MenuBar();
        //this.bar.prefWidthProperty().bind(this.main.stage.widthProperty());
        bar.useSystemMenuBarProperty().set(true);

        //main.bp.setTop(this.bar);
        this.main.layout.setTop(this.bar);

        // File menu - new, save, exit
        javafx.scene.control.Menu fileMenu = new javafx.scene.control.Menu("File");
        javafx.scene.control.MenuItem newMenuItem = new javafx.scene.control.MenuItem("New");
        javafx.scene.control.MenuItem saveMenuItem = new javafx.scene.control.MenuItem("Save");
        javafx.scene.control.MenuItem exitMenuItem = new javafx.scene.control.MenuItem("Exit");
         //exitMenuItem.setOnAction(actionEvent -> Platform.exit());
        fileMenu.getItems().addAll(newMenuItem, saveMenuItem, new SeparatorMenuItem(), exitMenuItem);
        
        // view menu
        javafx.scene.control.Menu viewMenu = new javafx.scene.control.Menu("View");
        toggleToolbox = new javafx.scene.control.CheckMenuItem("Toolbox");
        toggleToolbox.setSelected(true);
        UmlController controller = main.controller;
        toggleToolbox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                controller.showToolbox(toggleToolbox.isSelected());
            }
        });
        viewMenu.getItems().add(toggleToolbox);
        
        // add to main bar
        this.bar.getMenus().addAll(fileMenu, viewMenu);
    }
}
