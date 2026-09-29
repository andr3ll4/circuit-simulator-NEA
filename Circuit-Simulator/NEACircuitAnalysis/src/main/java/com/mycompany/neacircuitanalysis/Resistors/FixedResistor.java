/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.neacircuitanalysis.Resistors;

public class FixedResistor extends Resistor {
    int FResCount =0;
    
    public FixedResistor(){
        FResCount++;
        name = "fRes" + FResCount;
        V = null; I = null; Q = null; T = null; P = null; E = null; C = null;
        R = 20.0;
        pRating = null;
        linear = true;
    }
    public FixedResistor (String name, Double R){
        this.name = name;
        this.R = R;
        I = null; V = null; Q = null; T = null; P = null; E = null; 
        pRating = null;
        linear = true;
    }
}
