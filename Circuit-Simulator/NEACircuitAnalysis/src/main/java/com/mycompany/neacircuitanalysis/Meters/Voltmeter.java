/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.neacircuitanalysis.Meters;

public class Voltmeter extends Meter {
    int vMeterCount =0;
    public Voltmeter(){  
        vMeterCount++;
        name = "vMeter" + vMeterCount;
        R = 10.0 * Math.pow(10,6); 
        V = null; I = null; Q = null; T = null; P = null; E = null; C = null;
        pRating = null;
        linear = true;
    }
    public Voltmeter(String name){  
        this.name = name;
        R = 10.0 * Math.pow(10,6);
        V = null; I = null; Q = null; T = null; P = null; E = null; C = null;
        pRating = null;
        linear = true;
    }
}
