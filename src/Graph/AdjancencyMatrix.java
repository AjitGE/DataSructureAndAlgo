package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjancencyMatrix<T> implements Graph{
    private int numberOfVertex=0;
    private int [][] adjacentMatrix;
    private GraphType graphType;


    public AdjancencyMatrix(int numberOfVertex,GraphType graphType){
        this.numberOfVertex = numberOfVertex;
        this.graphType = graphType;
        adjacentMatrix = new int[numberOfVertex][numberOfVertex];
             for (int i = 0; i < numberOfVertex ; i++){
                 for (int j = 0;  j < numberOfVertex ; j++){
                     adjacentMatrix[i][j]=0;
                 }
             }

    }



    @Override
    public void addRelationShip(int vertex1, int vertex2) {
        if (vertex1<0|| vertex1>=numberOfVertex|| vertex2<0 ||vertex2>=numberOfVertex){
            throw new IllegalArgumentException("Vertex is out of range to "+ numberOfVertex);

        }

        adjacentMatrix[vertex1][vertex2]=1;
        if(graphType.equals(GraphType.UNDIRECTED))
        {
            adjacentMatrix[vertex2][vertex1]=1;
        }

    }

    @Override
    public List<Integer> getAdjacentVertices(int vertex) {

    List<Integer> adjacentVertex = new ArrayList<>(numberOfVertex);
        if (vertex<0|| vertex>=numberOfVertex)
        {
            throw new IllegalArgumentException("Vertex is out of range to "+ numberOfVertex);
        }

        for (int i=0;i<numberOfVertex;i++){
            if (adjacentMatrix[vertex][i]==1){
                adjacentVertex.add(i);
            }
        }
        Collections.sort(adjacentVertex);
        return adjacentVertex;

    }
}
