/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UMLEditor;

public class Style {
    // static fx
    private static final String background_color_label = "-fx-background-color";
    private static final String link = ": ";
    
    // configurable
    private static final String background_color = "dddddd";
    
    // external useage
    public String bgColor;
    
    public Style(){
        this.bgColor = Style.background_color_label + Style.link + Style.background_color;
    }

}
