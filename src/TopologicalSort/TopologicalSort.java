package TopologicalSort;

import Graph.Graph;
import Graph.AdjacencySet;

import java.util.*;

import Graph.Node;

public class TopologicalSort<T> extends AdjacencySet {



    public TopologicalSort(int numberOfVertices, GraphType graphType) {
        super(numberOfVertices, graphType);
    }



    public List<Integer> topologicalSort(){
        int numberOfVertex= getNumberOfVertices();
        Map<Integer,Integer>  vertexInDegreeMap = new HashMap<>();
        LinkedList<Integer> queue = new LinkedList<>();
        List<Integer> topologicalSortedList = new ArrayList<>();

        for (int vertex= 0; vertex<numberOfVertex;vertex++){
            int inDegree= getInDegree(vertex);
        vertexInDegreeMap.put(vertex,inDegree);
        if (inDegree==0){
            queue.add(vertex);
        }
        }

        while(!queue.isEmpty()){
            int vertex= queue.poll();
            topologicalSortedList.add(vertex);
            for (Object adjacentVertex:getAdjacentVertices(vertex)) {

                    int updatedInDegree = getInDegree((int)adjacentVertex)-1;
                        vertexInDegreeMap.remove(adjacentVertex);
                        vertexInDegreeMap.put((Integer)adjacentVertex,updatedInDegree);
                if (updatedInDegree==0){
                queue.add((int)adjacentVertex);
                }

                }
            }
        if (topologicalSortedList.size()!=numberOfVertex){
            System.out.println("graph is cyclic in nature");
        }
        return topologicalSortedList;
        }





    }

