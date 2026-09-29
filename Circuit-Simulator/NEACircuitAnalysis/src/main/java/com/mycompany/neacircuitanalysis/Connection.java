/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.neacircuitanalysis;

import java.util.*;

public class Connection {
    private List<Component> nTerminal;
    private List<Component> pTerminal;
    private String name;
    int conCount =0;
    
    public Connection(){
        conCount++;
        name = "n" + conCount;
    }
    public Connection(List<Component> pTerminal, List<Component> nTerminal){
        conCount++;
        name = "n" + conCount;
        this.nTerminal=nTerminal;
        this.pTerminal=pTerminal;
    }

    public List<Component> getnTerminal() {
        return nTerminal;
    }

    public void setnTerminal(List<Component> nTerminal) {
        this.nTerminal = nTerminal;
    }

    public List<Component> getpTerminal() {
        return pTerminal;
    }

    public void setpTerminal(List<Component> pTerminal) {
        this.pTerminal = pTerminal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addToNTerminal(Component comp){
        nTerminal.add(comp);
    }
    public void addToPTerminal(Component comp){
        pTerminal.add(comp);
    }
}
