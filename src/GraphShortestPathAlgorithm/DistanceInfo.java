package GraphShortestPathAlgorithm;

import Graph.Graph;

public class DistanceInfo {
   private int distance;
   private int lastVertex;

   public DistanceInfo(){
       distance=-1;
       lastVertex=-1;
   }
    public int getDistance() {
        return distance;
    }

    public int getLastVertex() {
        return lastVertex;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setLastVertex(int lastVertex) {
       this.lastVertex = lastVertex;
    }


}

