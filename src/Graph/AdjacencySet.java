package Graph;


import java.util.*;

public class AdjacencySet<T> implements Graph<T>{
    private List<Node> adjacentVertices= new ArrayList<>();
    private GraphType graphType ;
    private int numberOfVertices;

    public AdjacencySet(int numberOfVertices, GraphType graphType){
        this.graphType = graphType;
        this.numberOfVertices =numberOfVertices;
        for (int i=0; i<numberOfVertices;i++){
            adjacentVertices.add(new Node(i));
        }

    }


    @Override
    public void addRelationShip(int vertex1, int vertex2) {
     if (vertex1<0 || vertex1 >=numberOfVertices || vertex2<0 || vertex2 >=numberOfVertices){
         throw new IllegalArgumentException("Vertex are out of bound");
     }
     adjacentVertices.get(vertex1).addRelationShip(vertex2);
     if(graphType.equals(GraphType.UNDIRECTED)){
         adjacentVertices.get(vertex2).addRelationShip(vertex1);

     }
    }


    @Override
    public List<T> getAdjacentVertices(int vertex) {
        List<Integer> adjacentVerticesList = new ArrayList<>(numberOfVertices);
        if (vertex<0 || vertex>=numberOfVertices ){
            throw new IllegalArgumentException("Vertex are out of bound");
        }
       return adjacentVertices.get(vertex).getAdjacentVertex();

    }

    public void depthFistTraversal(Graph graph,int[] visited,int currentVertex){
        if (visited[currentVertex]==1){
            return;
        }
        visited[currentVertex]=1;

        List<Integer> adjacentVertex=graph.getAdjacentVertices(currentVertex);
        for(int vertex: adjacentVertex){
            depthFistTraversal(graph,visited,vertex);
        }
        System.out.println(currentVertex+"-->");

    }

    public void breadthFirstTraversal(Graph graph,int[] visited,int currentVertex){
        LinkedList<Integer> queue = new LinkedList();


        queue.add(currentVertex);
        while(!queue.isEmpty()){

            int vertex=queue.poll();

            if (visited[vertex]==1){
                continue;
            }
            System.out.println(vertex+" -->");
            visited[vertex]=1;
            List<Integer> adjacentVertex = graph.getAdjacentVertices(vertex);
            for (int v: adjacentVertex){
            if(visited[v]!=1){
                queue.add(v);
            }
            }
        }




    }

    public int getNumberOfVertices(){
        return numberOfVertices;
    }

    public List<Node> getVertexList(){
        return adjacentVertices;
    }

    public int getInDegree(int vertex){
        int inDegree=0;

        int numberOfVertex= getNumberOfVertices();
        for (int i= 0; i<numberOfVertex;i++){
            if(getAdjacentVertices(vertex).contains(i)){
                inDegree++;
            }

        }
        return inDegree;
    }

    public int getWeights(int source, int adjancentVertex) {
        return 1;
    }
}
