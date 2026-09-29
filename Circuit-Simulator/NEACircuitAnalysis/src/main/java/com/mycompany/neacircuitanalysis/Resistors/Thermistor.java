/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.neacircuitanalysis.Resistors;

public class Thermistor extends VarResistor{
    int thermisCount =0;
    public Thermistor(){
        thermisCount++;
        name = "Thermis" + thermisCount;
        V = null; I = null; Q = null; T = null; P = null; E = null; C = null;
        R = 20.0;
        pRating = null;
        linear = false;
    }
    public Thermistor (String name, Double R){
        this.name = name;
        this.R = R;
        I = null; V = null; Q = null; T = null; P = null; E = null; 
        pRating = null;
        linear = false;
    }
}
