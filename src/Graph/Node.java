package Graph;

import java.util.*;

public class Node {
    private final int vertexID;
    private final List<Integer> adjacencySet = new ArrayList<>();
 public Node(int vertexID){
     this.vertexID=vertexID;
 }
    public int getVertices() {
        return vertexID;
    }


    public void addRelationShip(int vertices){
        adjacencySet.add(vertices);
    }
    public List<Integer> getAdjacentVertex(){
     List<Integer> sortedAdjacencyList = new ArrayList<>(adjacencySet);
     Collections.sort(sortedAdjacencyList);
     return sortedAdjacencyList;
    }
}
