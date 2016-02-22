
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author niksat21
 */
public class EulerPathCircuit {
    
    public static void main(String[] args) throws FileNotFoundException{
        
        Scanner sc = new Scanner(new File("C:\\Spring16\\Impl6301002\\LP0\\lp0-big.txt"));
        Graph g = Graph.readGraph(sc, false);
        ArrayList<Edge> tour = new ArrayList<>();
        System.out.println("input read");
        g.calcInDeg();
        //g.printAdjList();
        //g.printInDeg();
        ArrayList<Vertex> verts = g.getBaseList();
        ArrayList<Edge> edgeList = g.edgeList();
        long startTime = System.currentTimeMillis();

        boolean flag = false;
        for(Vertex in : verts){
            if(in == null)
                continue;
            else{
            //System.out.println(""+in);
            if(in.indeg%2==0)
                flag=true;
            else
                flag=false;
            }
        }
        if(flag==true){
        Vertex source = verts.get(1);
        
        Vertex u = source.Adj.get(0).To ;
        tour.add(source.Adj.get(0));
        if(source==source.Adj.get(0).To){
                u=source.Adj.get(0).From;
                source=source.Adj.get(0).To;
            }
            else{
                u = source.Adj.get(0).To;
                source = source.Adj.get(0).From;
            }
        
        
        source.Adj.remove(0);
        u.Adj.remove(0);
        source.indeg--;
        u.indeg--;
        //g.printAdjList();
        
        
        System.out.println("processing started");
        
        
        while(u.indeg!=0){
           
            
           
            Edge e=null;
           
            for(Edge in : u.Adj){
                
                
                if((in.From == source || in.To ==source )&& u.Adj.size()>1){
                    
                    continue;
                }
                    
                else if(u.Adj.size()==1 && (in.From == source || in.To ==source)){
                    
                    e=in;
                    tour.add(e);
                    source=source.Adj.get(0).To;
                }
                else{
                     e =in;
                     tour.add(e);
                    break;
                }
                   
            }
           
            if(e==null)
                break;
            
            
           
            Vertex v = null;
            if(u==e.To){
                v=e.From;
                u=e.To;
            }
            else{
                v = e.To;
                u = e.From;
            }
            
            u.Adj.remove(e);
            
            
            
            
            v.Adj.remove(e);
            
            u.indeg--;
            v.indeg--;
            u=v;
            
        }
        
        System.out.println(""+tour.size());
        System.out.println("Completed Main");
        long endTime = System.currentTimeMillis();
        long diff = endTime-startTime;
        System.out.println("time taken"+diff);
        
        }
        else{
            System.out.println("not a tour");
        }
    }
    
    
}    

