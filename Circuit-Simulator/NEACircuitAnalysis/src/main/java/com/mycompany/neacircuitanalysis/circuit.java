
package com.mycompany.neacircuitanalysis;
import java.util.*;

public class circuit {
    private Map<Component, List<Connection>> circuitMap;
    private Set<Component> allComponents = new HashSet<>();
    private Set<Connection> allConnection = new HashSet<>();
    
    
    public circuit(){ //create empty circuit
        circuitMap= new HashMap<>();
    }
    public circuit(Map<Component, List<Connection>> circuitMap) { 
        this.circuitMap = circuitMap;
        circuitMap.forEach((k,v)-> allComponents.add(k));
        circuitMap.forEach((k,v)-> allConnection.addAll(v));
    }
    public void addComponent(Component comp){
        circuitMap.put(comp, new ArrayList<>());
        allComponents.add(comp);
    }
    public void addConnection(Component comp, List<Connection> con){
        if(circuitMap.containsKey(comp)){
            circuitMap.remove(comp);
        }
        circuitMap.put(comp, con);
        allConnection.addAll(con);
    }
    public String traverse(){
        //BFS
        return "";
    }
    public boolean checkConnected(){
        //DFS
        return false;
    }

    public Map<Component, List<Connection>> getCircuitMap(){
        return circuitMap;
    }

    public Component[] getAllComponents() {
        return allComponents.toArray(Component[]::new);
    }

    public Connection[] getAllConnection() {
        return allConnection.toArray(Connection[]::new);
    }

}
