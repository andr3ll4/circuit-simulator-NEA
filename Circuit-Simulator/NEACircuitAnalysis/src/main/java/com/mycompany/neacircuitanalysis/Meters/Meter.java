/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.neacircuitanalysis.Meters;
import com.mycompany.neacircuitanalysis.Component;


public class Meter extends Component{
    int meterCount =0;
    public Meter(){  
        meterCount++;
        name = "Meter" + meterCount;
        R = null; V = null; I = null; Q = null; T = null; P = null; E = null; C = null;
        pRating = null;
        linear = true;
    }
    public Meter(String name){  
        this.name = name;
        R = null; V = null; I = null; Q = null; T = null; P = null; E = null; C = null;
        pRating = null;
        linear = true;
    }
}
