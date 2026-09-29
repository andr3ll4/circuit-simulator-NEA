/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.neacircuitanalysis;


public class Cell extends Component{
    int cellCount = 0;
    
    public Cell(){
        cellCount++;
        name = "Cell" + cellCount;
        V = 0.0; 
        I = null; R = null; Q = null; T = null; P = null; E = null; C = null;
        pRating = null;
        linear = true;
    }
    public Cell (String name, Double V){
        this.name = name;
        this.V = V;
        I = null; R = null; Q = null; T = null; P = null; E = null; 
        pRating = null;
        linear = true;
    }
}
