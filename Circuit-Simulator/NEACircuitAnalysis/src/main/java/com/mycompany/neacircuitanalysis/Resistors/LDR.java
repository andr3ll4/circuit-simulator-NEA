/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.neacircuitanalysis.Resistors;

public class LDR extends VarResistor {
    int LDRCount =0;
    private Double LI;
    public LDR(){
        LDRCount++;
        name = "LDR" + LDRCount;
        V = null; I = null; Q = null; T = null; P = null; E = null; C = null; LI = null;
        R = 20.0;
        pRating = null;
        linear = false;
    }
    public LDR (String name, Double R){
        this.name = name;
        this.R = R;
        I = null; V = null; Q = null; T = null; P = null; E = null; LI = null;
        pRating = null;
        linear = false;
    }

    public Double getLI() {
        return LI;
    }

    public void setLI(Double LI) {
        this.LI = LI;
    }
    
}
