/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.neacircuitanalysis.Meters;

public class Ammeter extends Meter{
    int aMeterCount =0;
    public Ammeter(){  
        aMeterCount++;
        name = "aMeter" + aMeterCount;
        R = 0.1; 
        V = null; I = null; Q = null; T = null; P = null; E = null; C = null;
        pRating = null;
        linear = true;
    }
    public Ammeter(String name){  
        this.name = name;
        R = 0.1;
        V = null; I = null; Q = null; T = null; P = null; E = null; C = null;
        pRating = null;
        linear = true;
    }
}
