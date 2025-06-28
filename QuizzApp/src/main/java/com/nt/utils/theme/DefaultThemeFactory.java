/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nt.utils.theme;

import com.nt.quizzapp.App;

/**
 *        return App.class.getResource("style.css").toExternalForm();

 * @author admin
 */
public class DefaultThemeFactory implements ThemeFactory{

    @Override
    public String getStyleSheet() {
        return App.class.getResource("styles.css").toExternalForm();
    }
    
}
