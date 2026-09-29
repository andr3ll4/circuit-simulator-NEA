/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.neacircuitanalysis;


public class Wire extends Component{
    private Double rho;
    private Double L;
    private Double A;
    private Double v;
    int wireCount =0;
    
    public Wire(){
        wireCount++;
        name = "Wire" + wireCount;
        V = null; I = null; R = null; Q = null; T = null; P = null; E = null; C = null;
        pRating = null;
        linear = true;
        rho = 1.7 * Math.pow(10, -8); //default wire as copper
        L = 0.01;
        A = 2 * Math.pow(10, -6);
        v = null;
    } public Wire(Double rho, Double A, Double L){
        wireCount++;
        name = "Wire" + wireCount;
        V = null; I = null; R = null; Q = null; T = null; P = null; E = null; C = null;
        pRating = null;
        linear = true;
        this.rho = rho;
        this.L = L;
        this.A = A;
        v = null;
    }

    public Double getRho() {
        return rho;
    }

    public void setRho(Double rho) {
        this.rho = rho;
    }

    public Double getL() {
        return L;
    }

    public void setL(Double L) {
        this.L = L;
    }

    public Double getA() {
        return A;
    }

    public void setA(Double A) {
        this.A = A;
    }

    public Double getv() {
        return v;
    }

    public void setv(Double v) {
        this.v = v;
    }

}
