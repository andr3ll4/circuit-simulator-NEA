/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.neacircuitanalysis;


public class Component {
    protected String name;
    protected Double V; //potential difference
    protected Double I; //current
    protected Double R; //resistance
    protected Double Q; //charge
    protected Double T; //temperature
    protected Double P; //power
    protected Double E; //energy
    protected Double C; //capacitance
    protected Double pRating;
    protected boolean linear;
    int compCount = 0;
    
    public Component(){
        compCount++;
        name = "Comp" + compCount;
        V = null; I = null; R = null; Q = null; T = null; P = null; E = null; C = null;
        pRating = null;
        linear = true;

    }
    public Component(String name){
        this.name = name;
        V = null;
        I = null;
        R = null;
        Q = null;
        T = null;
        P = null;
        E = null;
        C = null;
        pRating = null;
        linear = true;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public Double getV() {
        return V;
    }

    public void setV(Double V) {
        this.V = V;
    }

    public Double getI() {
        return I;
    }

    public void setI(Double I) {
        this.I = I;
        try{
           if(V*I>pRating){
            blow();
           } 
        }catch(NullPointerException e){
            
        }
        
    }

    public Double getR() {
        return R;
    }

    public void setR(Double R) {
        this.R = R;
    }

    public Double getQ() {
        return Q;
    }

    public void setQ(Double Q) {
        this.Q = Q;
    }

    public Double getT() {
        return T;
    }

    public void setT(Double T) {
        this.T = T;
    }

    public Double getP() {
        return P;
    }

    public void setP(Double P) {
        this.P = P;
    }

    public Double getE() {
        return E;
    }

    public void setE(Double E) {
        this.E = E;
    }

    public Double getC() {
        return C;
    }

    public void setC(Double C) {
        this.C = C;
    }

    public Double getpRating() {
        return pRating;
    }

    public void setpRating(Double pRating) {
        this.pRating = pRating;
    }

    public boolean isLinear() {
        return linear;
    }

    public void setLinear(boolean linear) {
        this.linear = linear;
    }
    public void blow(){
        System.out.println( name + " has blown!");
    }
    
}
