package GraphShortestPathAlgorithm;

import Graph.AdjacencySet;

import java.util.*;

public class DistanceTable {

 public Map<Integer,DistanceInfo> createDistanceTable(AdjacencySet graph, int source) {
     Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
     LinkedList<Integer> queue = new LinkedList<Integer>();
     DistanceInfo distanceInfo = new DistanceInfo();
     for (int i = 0; i < graph.getNumberOfVertices(); i++) {
         distanceTable.put(i, distanceInfo);
     }
     distanceTable.get(source).setDistance(0);
     distanceTable.get(source).setLastVertex(source);
     queue.add(source);

     while (!queue.isEmpty()) {
         int currentVertex = queue.pollFirst();
         for (int adjacentVertex : (List<Integer>) graph.getAdjacentVertices(currentVertex)) {
             int currentDistance = distanceTable.get(adjacentVertex).getDistance();
             if (currentDistance == -1) {
                 currentDistance = 1 + distanceTable.get(currentVertex).getDistance();
                 distanceTable.get(adjacentVertex).setDistance(currentDistance);
                 distanceTable.get(adjacentVertex).setLastVertex(currentVertex);
                 if (!graph.getAdjacentVertices(adjacentVertex).isEmpty())
                     queue.add(adjacentVertex);

             }

         }


     }
     return distanceTable;
 }

 public void shortestPath(AdjacencySet graph,int source,int destination){
     Map<Integer,DistanceInfo> distanceTable = createDistanceTable(graph,source);
     Stack stack = new Stack();
     stack.push(destination);
     int previousVertex= distanceTable.get(destination).getLastVertex();
     while(previousVertex!=-1 && previousVertex!=source){
         stack.push(previousVertex);
         previousVertex = distanceTable.get(destination).getLastVertex();

     }
 if(previousVertex==-1){
     System.out.println("No shortest path is possible");
 }
 else{
     System.out.println("Shortest path from "+source);
     while((!stack.isEmpty())){
         System.out.print("-->"+stack.pop());

     }
     System.out.print("shortest oath is found");
 }



 }
}







