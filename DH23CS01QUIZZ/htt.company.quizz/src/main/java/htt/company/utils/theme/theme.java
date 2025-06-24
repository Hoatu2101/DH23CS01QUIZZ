/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package htt.company.utils.theme;

/**
 *
 * @author admin
 */
public enum theme {
    DEFAULT {
        @Override
        public void updateThem() {
           themeManager.setThemFactory(new darkTheme());
        } 
    },DARK {
        @Override
        public void updateThem() {
            themeManager.setThemFactory(new lightTheme());// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    },LIGHT {
        @Override
        public void updateThem() {
            themeManager.setThemFactory(new defaultTheme()); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    };
     public abstract  void updateThem();
}
