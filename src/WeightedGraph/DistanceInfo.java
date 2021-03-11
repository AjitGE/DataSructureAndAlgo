package WeightedGraph;

class DistanceInfo{
    private int lastVertex;
    private int distance;
    public DistanceInfo(){
        this.lastVertex= -1;
        this.distance = Integer.MAX_VALUE;
    }

    public int getLastVertex(){
        return lastVertex;
    }

    public int getDistance(){
        return distance;
    }

    public void setLastVertex(int vertex){
        this.lastVertex= vertex;

    }

    public void setDistance(int distance){
        this.distance = distance;

    }
}
