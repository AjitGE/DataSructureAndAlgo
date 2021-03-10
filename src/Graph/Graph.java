package Graph;

import java.util.List;

public interface Graph<T> {
    enum GraphType{
        UNDIRECTED,
        DIRECTED
    }
    public void addRelationShip(int vertex1, int vertex2);
    public List<T> getAdjacentVertices(int vertex);
}
