/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntt.themes;

import com.ntt.quizapp.App;

/**
 *
 * @author NGUYEN THUAN
 */
public class DefaultThemeFactory implements ThemeFactory{
    @Override
    public String getStyleSheet(){
        return App.class.getResource("style.css").toExternalForm();
    }
}
