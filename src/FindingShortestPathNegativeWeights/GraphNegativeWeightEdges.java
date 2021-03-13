package FindingShortestPathNegativeWeights;

import Graph.AdjacencySet;
import Graph.Graph;

import java.util.*;

public class GraphNegativeWeightEdges {

    public class DistanceInfo{
        private int lastVertex;
        private int distance;

        public DistanceInfo(){
            lastVertex =-1;
            distance =Integer.MAX_VALUE;
        }

        public int getLastVertex(){
            return lastVertex;
        }

        public int getDistance(){
            return distance;
        }

        public void setDistance(int distance){
            this.distance = distance;
        }

        public void setLastVertex(int distance){
            this.lastVertex= lastVertex;
        }
    }

    public Map<Integer,DistanceInfo> createDistanceTable(AdjacencySet graph,int source){
        Map<Integer,DistanceInfo> distanceInfoMap = new HashMap<>();
        LinkedList<Integer> queue = new LinkedList<>();


        for (int vertex=0; vertex<graph.getNumberOfVertices();vertex++){
            queue.add(vertex);
            distanceInfoMap.put(vertex,new DistanceInfo());
        }
        distanceInfoMap.get(source).setDistance(0);
        distanceInfoMap.get(source).setDistance(source);



        for (int iteration=0 ;iteration<graph.getNumberOfVertices()-1;iteration++){
            while(!queue.isEmpty()){
            int currentVertex = queue.pollFirst();

            for (int vertex=0; vertex<graph.getNumberOfVertices();vertex++){
                queue.add(vertex);
            }
            Set<String> visitedEdges = new HashSet<>();

            for (int neighbor : (List<Integer>)graph.getAdjacentVertices(currentVertex)){
                String edge = String.valueOf(currentVertex)+String.valueOf(neighbor);

                if (visitedEdges.contains(edge)){
                    continue;
                }
                visitedEdges.add(edge);
               int distance = distanceInfoMap.get(currentVertex).getDistance()+
                       graph.getWeights(currentVertex,neighbor);
              if (distanceInfoMap.get(neighbor).getDistance()>distance){
                  distanceInfoMap.get(neighbor).setDistance(distance);
                  distanceInfoMap.get(neighbor).setDistance(currentVertex);
              }

            }

        }

        }
        for (int vertex=0; vertex<graph.getNumberOfVertices();vertex++){
            queue.add(vertex);
        }
        for (int lastIteration= 0; lastIteration<graph.getNumberOfVertices();lastIteration++){
            while(!queue.isEmpty()){
                int currentVertex = queue.pollFirst();

                for (int neighbor:(List<Integer>) graph.getAdjacentVertices(currentVertex)){

                    int distance = distanceInfoMap.get(currentVertex).getDistance()+
                            graph.getWeights(currentVertex,neighbor);
                    if (distanceInfoMap.get(neighbor).getDistance()>distance){
                        System.out.println("Negative cycle is found");
                    }

                }
            }
        }
        return distanceInfoMap;
    }

    public void shortestPath(int source,int destination){
        Stack<Integer> stack = new Stack<>();
        AdjacencySet graph = new AdjacencySet(5, Graph.GraphType.DIRECTED);
        Map<Integer,DistanceInfo> distanceTable = createDistanceTable(graph,0);
        stack.push(destination);


        int previousVertex =  distanceTable.get(destination).lastVertex;
        while (previousVertex!=-1 && previousVertex!=source){
            stack.push(previousVertex);
            previousVertex = distanceTable.get(previousVertex).lastVertex;
        }
        if (previousVertex==-1){
            while (!stack.isEmpty()){
                
            }
        }

    }
}
