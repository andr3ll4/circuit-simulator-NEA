/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.neacircuitanalysis;

public class Switch extends Component {
    public boolean closed;
    private int swCount = 0;
    
    public Switch(){
        swCount++;
        name = "Sw" + swCount;
        C = null; V = null; I = null; R = null; Q = null; T = null; P = null; E = null; 
        pRating = null;
        linear = true;
    }
    public Switch(String name){
        this.name = name;
        C=null; V = null; I = null; R = null; Q = null; T = null; P = null; E = null; 
        pRating = null;
        linear = true;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}
