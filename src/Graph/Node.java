package Graph;

import java.util.*;

public class Node<T extends Comparable<? super T>> {
    private final int vertexID;
    private final List<T> adjacencySet = new ArrayList<>();
 public Node(int vertexID){
     this.vertexID=vertexID;
 }
    public int getVertices() {
        return vertexID;
    }


    public void addRelationShip(T vertices){
        adjacencySet.add(vertices);
    }
    public List<T> getAdjacentVertex(){
     List<T> sortedAdjacencyList = new ArrayList<>(adjacencySet);
     Collections.sort(sortedAdjacencyList);
     return sortedAdjacencyList;
    }
}
