/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.neacircuitanalysis.Diodes;

public class LED extends Diode{
    int LEDcount = 0;
    private Double lumFlux;
    private String colour;
    
    public LED(){
        LEDcount++;
        name = "LED" + LEDcount;
        V = null; I = null; R = null; Q = null; T = null; P = null; E = null; C = null;
        pRating = null;
        linear = false;
        colour = "RED";
        lumFlux = 0.0;
    }
    public LED (String name, String colour){
        this.name = name;
        this.colour = colour;
        V=null; I = null; R = null; Q = null; T = null; P = null; E = null; 
        pRating = null;
        linear = false;
        lumFlux = 0.0;
    }

    public Double getLumFlux() {
        return lumFlux;
    }

    public void setLumFlux(Double lumFlux) {
        this.lumFlux = lumFlux;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
    
}
