/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package htt.company.utils.theme;

import javafx.scene.Scene;


/**
 *
 * @author admin
 */
public class themeManager {
    private static themeFactory themeFac = (themeFactory) new darkTheme();
    public static void setThemFactory(themeFactory f){
    
    themeFac=f;
    }
    public static void applyTheme(Scene scene ){
    scene.getRoot().getStylesheets().clear();
        scene.getRoot().getStylesheets().add(themeFac.getStyleSheet());
    }
}

