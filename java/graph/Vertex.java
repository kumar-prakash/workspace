public class Vertex {
    int weight;
    int node;
    Vertex pred;
    int distance;
    boolean visited;

    public Vertex(int node) {
        this.node = node;
    }

    public int hashCode() {
        return node;
    }

    public boolean equals(Object v) {
        if(v == null || !(v instanceof Vertex)) {
            return false;
        }
        Vertex that = (Vertex)v;
        return that.node == this.node;
    }

    public String toString() {
        return String.valueOf(this.node);
    }
}