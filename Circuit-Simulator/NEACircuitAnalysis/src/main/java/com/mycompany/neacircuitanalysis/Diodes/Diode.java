/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.neacircuitanalysis.Diodes;
import com.mycompany.neacircuitanalysis.Component;

public class Diode extends Component {
    int diodeCount =0;
    
    public Diode(){
        diodeCount++;
        name = "Dio" + diodeCount;
        V = null; I = null; R = null; Q = null; T = null; P = null; E = null; C = null;
        pRating = null;
        linear = false;
    }
    public Diode (String name){
        this.name = name;
        V=null; I = null; R = null; Q = null; T = null; P = null; E = null; 
        pRating = null;
        linear = false;
    }
}
