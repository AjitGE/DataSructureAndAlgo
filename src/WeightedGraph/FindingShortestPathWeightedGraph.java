package WeightedGraph;

import Graph.AdjacencySet;
import Graph.Graph;

import java.util.*;

public class FindingShortestPathWeightedGraph {


    static class VertexInfo{
        private int vertexId;
        private int distance;

        public VertexInfo(int vertexId,int distance){
            this.vertexId =vertexId;
            this.distance = distance;
        }

        public int getDistance(){
            return distance;
        }

        public int getVertexId(){
            return vertexId;
        }

    }

        public static Map<Integer,DistanceInfo> createDistanceTable(AdjacencySet graph, int source){
            Map<Integer,DistanceInfo> distanceInfoMap = new HashMap<>();
            Map<Integer,VertexInfo> vertexInfoMap = new HashMap<>();
            PriorityQueue<VertexInfo> queue = new PriorityQueue<>((vertex1, vertex2) ->
                    ((Integer)vertex1.getDistance()).compareTo(vertex2.getDistance()));


            DistanceInfo distanceInfo= new DistanceInfo();
            for (int vertex : (List<Integer>)graph.getVertexList()){
            distanceInfoMap.put(vertex,distanceInfo);
            }
            distanceInfoMap.get(source).setDistance(0);
            distanceInfoMap.get(source).setLastVertex(source);
            vertexInfoMap.put(source,new VertexInfo(source,0) );

            queue.add(vertexInfoMap.get(source));

            while(!queue.isEmpty()){
                VertexInfo vertexInfo = queue.poll();
                int currentVertex=vertexInfo.getVertexId();

                for (int adjacentVertex: (List<Integer>)graph.getAdjacentVertices(currentVertex)){

                    int lastVertex= distanceInfoMap.get(currentVertex).getLastVertex();
                    int weightedDistance = distanceInfoMap.get(currentVertex).getDistance()+
                             graph.getWeights(source,adjacentVertex);
                             if (distanceInfoMap.get(adjacentVertex).getDistance()>weightedDistance) {
                                 distanceInfoMap.get(adjacentVertex).setDistance(weightedDistance);
                                 distanceInfoMap.get(adjacentVertex).setLastVertex(lastVertex);
                                 VertexInfo neighborInfo = vertexInfoMap.get(adjacentVertex);
                                 if (neighborInfo != null) {
                                     queue.remove(neighborInfo);
                                 }
                                 neighborInfo = new VertexInfo(adjacentVertex,weightedDistance);
                                 vertexInfoMap.put(adjacentVertex,neighborInfo);
                                 queue.add(neighborInfo);
                             }
                }
            }
return distanceInfoMap;
        }

        public void shortestPath(int source,int destination){
        AdjacencySet graph = new AdjacencySet(5, Graph.GraphType.UNDIRECTED);
        Map<Integer,DistanceInfo> distanceTable = createDistanceTable(graph,source);
        Stack<Integer> stack = new Stack();
        stack.push(destination);
            int previousVertex = distanceTable.get(destination).getLastVertex();
        while(previousVertex!=1 && previousVertex!=source){
            stack.push(previousVertex);
            previousVertex = distanceTable.get(previousVertex).getLastVertex();
        }
        if (previousVertex==-1){
            System.out.println("No path is possible");
        }
        else {
            System.out.println("Shortest path is "+source );
            while(stack.isEmpty()){
                System.out.print("-->"+stack.pop());
            }
        }

        }
    }



