import java.util.List;

public class Vertex {
    private int index;
    List<Edge> edges;

    public Vertex(int in, List<Edge> e) {
        index = in;
        edges = e;
    }
    int getSize(){
        return edges.size();
    }

}