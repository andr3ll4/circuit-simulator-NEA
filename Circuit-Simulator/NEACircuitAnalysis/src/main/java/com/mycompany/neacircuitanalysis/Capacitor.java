/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.neacircuitanalysis;


public class Capacitor extends Component{
    private int capCount = 0;
    
    public Capacitor(){
        capCount++;
        name = "Cap" + capCount;
        C = 0.0;
        V = null; I = null; R = null; Q = null; T = null; P = null; E = null; 
        pRating = null;
        linear = true;
    }
    public Capacitor(String name, Double C){
        this.name = name;
        this.C = C;
        V = null; I = null; R = null; Q = null; T = null; P = null; E = null; 
        pRating = null;
        linear = true;
    }
    
}
