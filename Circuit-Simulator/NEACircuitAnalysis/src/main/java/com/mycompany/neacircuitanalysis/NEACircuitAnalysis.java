
package com.mycompany.neacircuitanalysis;
import com.mycompany.neacircuitanalysis.Resistors.Resistor;
import java.util.*;
import io.javalin.*;
public class NEACircuitAnalysis {

    public static void main(String[] args) {
        
        /* Javalin javAPI = Javalin.create(config -> {
            config.routes.get("/", ctx -> ctx.result("Connected"));
        }).start(5173);

        javAPI.post("/MNA/{circuit}", ctx -> {
            circuit circ = ctx.pathParam("circuit", circuit.class);
            double[] result = MNA(circ);
            ctx.json(result);
        }); */

        //example circuit
        Cell c1= new Cell("C1", 32.0);
        Cell c2 = new Cell("C2", 20.0);
        Resistor r1 = new Resistor("R1", 2.0);
        Resistor r2 = new Resistor("R2", 4.0);
        Resistor r3 = new Resistor("R3", 8.0);
        
        List<Component> n0negative = new ArrayList<>(); 
        n0negative.add(r3);
        n0negative.add(c2);
        List<Component> n0positive = new ArrayList<>(); 
        n0positive.add(r1);
        
        Connection n0 = new Connection(n0positive, n0negative);

        List<Component> n1negative = new ArrayList<>(); 
        n1negative.add(r1);
        List<Component> n1positive = new ArrayList<>(); 
        n1positive.add(c1);
        
        Connection n1 = new Connection(n1positive, n1negative);
        
        List<Component> n2negative = new ArrayList<>(); 
        n2negative.add(c1);
        List<Component> n2positive = new ArrayList<>(); 
        n2positive.add(r2);
        n2positive.add(r3);
        
        Connection n2 = new Connection(n2positive, n2negative);
        
        List<Component> n3negative = new ArrayList<>(); 
        n3negative.add(r2);
        List<Component> n3positive = new ArrayList<>(); 
        n3positive.add(c2);
        
        Connection n3 = new Connection(n3positive, n3negative);
        
        circuit circ = new circuit();
        circ.addComponent(c1);
        circ.addComponent(c2);
        circ.addComponent(r1);
        circ.addComponent(r2);
        circ.addComponent(r3);
        
        circ.addConnection(c1,new ArrayList<>(Arrays.asList(n1,n2)));
        circ.addConnection(r2, new ArrayList<>(Arrays.asList(n3,n2)));
        circ.addConnection(c2, new ArrayList<>(Arrays.asList(n0,n3)));
        circ.addConnection(r3, new ArrayList<>(Arrays.asList(n0,n2)));
        circ.addConnection(r1, new ArrayList<>(Arrays.asList(n0,n1)));
        
        MNA(circ);
    }
    public static double[] MNA(circuit c){
       Map<Component, List<Connection>> circuitMap = c.getCircuitMap(); //hashmap of circuit
       Connection[] nodes =   c.getAllConnection(); //all of the connections in an array
       Component[] comps = c.getAllComponents(); //all of the components in an array
       List<Component> vSources = new ArrayList<>(); //all voltage sources (had to use list as i will count the size as I assign to this)
       int m = 0; //stores number of voltage sources
       //counts the number of voltage sources and adds it to m
       for(Component comp : comps){ 
           if(comp instanceof Cell){
               vSources.add(comp);
               m++;
           }
       }
        
       int n = nodes.length-1; //counts the number of nodes being calculated (-1 for the reference node)
       
       
       double[][] Amatrix = new double[n+m][n+m]; 
       double[] Xmatrix = new double[m+n]; 
       double[] Zmatrix = new double[m+n];
       
       
       //fills matrices with 0
       for(int x = 0; x<n+m; x++){
           Zmatrix[x] = 0;
           Xmatrix[x] =0;
           for(int y = 0; y<n+m; y++){
               Amatrix[x][y]=0;
           }
       }
       
       //makes top left of A matrix (nxn)
       Connection refNode = nodes[0]; //can be anything, just to reference
        for (Component comp : comps) {
            if (comp instanceof Resistor && (circuitMap.get(comp).size() > 2 || (!circuitMap.get(comp).contains(refNode) && circuitMap.get(comp).size() > 1))) {
                //if this component is a resistor and it has more than 2 nodes or one of the nodes isnt a reference node
                for (int i = 1; i<nodes.length; i++) {
                    for (int p = i; p<nodes.length; p++) {
                        if (circuitMap.get(comp).contains(nodes[i]) && circuitMap.get(comp).contains(nodes[p])) { //checks which nodes has the resistor in common
                            Amatrix[i-1][p-1] = -1 / comp.getR(); 
                            Amatrix[p-1][i-1] = -1 / comp.getR();
                        }
                    }
                }
            }
        }
        
       int index =0; //
       for(Connection node : nodes){ //
           if(node != refNode){
               for(Component comp : node.getnTerminal()){
               if(comp instanceof Resistor){
                   Amatrix[index][index] += 1/comp.getR();
               }
           }
           index++;
           }
       }
  
       //rest of A matrix
       int sourcesFound =0; //using this as an "index" for the voltage sources
       for (Component comp : vSources) { 
           Zmatrix[n+sourcesFound] = comp.getV(); //add voltages into the Z matrix as im looping here already
            for(Connection node : circuitMap.get(comp)){ //for each node the cell is attached to 
                if(node!=refNode){ //if its not the reference node
                     if(node.getnTerminal().contains(comp)){ //if the node is connected to the -ive terminal of the cell
                          for(int x = 1; x<nodes.length; x++){ 
                              if(node == nodes[x]){ //finds which index the node has
                                  Amatrix[x-1][n+sourcesFound] = -1; //assigns -1
                                  Amatrix[n+sourcesFound][x-1] = -1;
                              }
                           }
                      }else if(node.getpTerminal().contains(comp)){ //same as first if but assigns 1 to +ive terminal
                           for(int x = 1; x<nodes.length; x++){
                               if(node == nodes[x]){ 
                                   Amatrix[x-1][n+sourcesFound] = 1;
                                   Amatrix[n+sourcesFound][x-1]=1;
                               }
                            }
                       }
                 }
                    
             }
             sourcesFound++; 
        }
 
       double[][] AInverse = findMatrixInverse(Amatrix, n, m);
       Xmatrix = matrixMultiplication(AInverse, Zmatrix);
       //finds and sets the voltage in the components by V from positive - V from negative
       for(int x = 1; x<nodes.length; x++){ 
           for(Component comp : nodes[x].getnTerminal() ){
               comp.setV(-Xmatrix[x-1]);
           }
           for(Component comp : nodes[x].getpTerminal() ){
               if(comp.getV() == null){
                   comp.setV(Xmatrix[x-1]);
               }else{
                   comp.setV(comp.getV() +Xmatrix[x-1]);
               }
               
           }
       }
       //sets the currents in sources
       for(int x = n; x<m+n; x++){
           for(Component comp: vSources){
               comp.setI(Xmatrix[x]);
           }
       }
       
       return Xmatrix;
    }
    public static double[][] findMatrixInverse(double[][] A, int n, int m){
        int ASize = m+n;
        double[][] matrix = new double[ASize][2*ASize];
        for(int x = 0; x<ASize; x++){
            System.arraycopy(A[x], 0, matrix[x], 0, ASize); //put A in 
        }
        
        for(int x = 0; x<ASize; x++){ //putting identity matrix in 
            for(int y = ASize; y<2*ASize; y++){
                if(x+ASize==y){
                    matrix[x][y]=1;
                }else{
                    matrix[x][y]=0;
                }
             }
        }
        
        for(int p = 0; p<ASize; p++){ //for each pivot and below
            
            for(int c = 0; c<2*ASize; c++){ 
                matrix[p][c]=matrix[p][c] * (1/matrix[p][p]); //make 1 by multiplying reciprocal whole row
             }
            if(p+1<ASize){
                for(int z = p +1; z<ASize; z++){
                     for(int c = p; c<2*ASize; c++){ 
                         matrix[z][c] += matrix[p][c] * -matrix[z][p]; // make 0 in reverse 
                      }           
                 }
            }    
        }
        
        for(int p = ASize-1; p>-1; p--){ //above each pivot
            
            if(p>0){
                for(int z = p -1; z>-1; z--){
                     for(int c = 0; c<2*ASize; c++){ 
                         matrix[z][c] += matrix[p-1][c] * - matrix[z][p]; // make 0 in reverse diagonal 
                      }           
                 }
            }    
        }
        double[][] result = new double[ASize][ASize];
        for(int x = 0; x<ASize; x++){
            System.arraycopy(matrix[x], ASize, result[x], 0, ASize); //put A in 
        }
        return result;
    }
    public static double[] matrixMultiplication(double[][] InvA, double[] Z){ 
        double[] X = new double[Z.length];
        for(int i = 0; i<Z.length; i++){
            X[i]=0;
            for(int j = 0; j<Z.length; j++){
                X[i] += InvA[i][j]*Z[j];
            }
        }
        return X;
    }
    
}
   