/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package htt.company.utils.theme;

import com.mycompany.htt.company.quizz.App;

/**
 *
 * @author admin
 */
public class darkTheme implements themeFactory{

    @Override
    public String getStyleSheet() {
        return App.class.getResource("dark.css").toExternalForm();
    }
    
}
