/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.neacircuitanalysis.Resistors;

public class Rheostat extends VarResistor {
    int rheoCount =0;
    public Rheostat(){
        rheoCount++;
        name = "Rheo" + rheoCount;
        V = null; I = null; Q = null; T = null; P = null; E = null; C = null;
        R = 20.0;
        pRating = null;
        linear = false;
    }
    public Rheostat (String name, Double R){
        this.name = name;
        this.R = R;
        I = null; V = null; Q = null; T = null; P = null; E = null; 
        pRating = null;
        linear = false;
    }
}
