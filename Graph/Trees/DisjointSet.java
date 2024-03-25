// NOTE: no. of edges = no. of vertices, then there exists a cycle. [property of minimum spanning tree]


// U N D I R E C T E D Tree

public class DisjointSet {
    int size[];
    int parent[];
    int v;

    DisjointSet(int v){
        this.v = v;
        size = new int[v];
        parent = new int[v];
        for(int i = 0; i < v; i++){
            parent[i] = -1;
        }

    }

    void isCycleDetected(int u, int v){ // u= source, v= destination
        int u_abs = find(u);
        int v_abs = find(v);
        if(u_abs == v_abs){
            System.out.println("Cycle detected");
            return;
        }
        union(u_abs, v_abs);
        
    }

    void union(int u_abs, int v_abs){
        if(size[u_abs] > size[v_abs]){
            parent[v_abs] = u_abs;
        }
        else if(size[u_abs] < size[v_abs]){
            parent[u_abs] = v_abs; // join the smaller one, this condition is when u_abs is smaller
        }
        else{
            parent[u_abs] = v_abs;
            size[v_abs]++;
        }
    }

    int find(int vertex){ // to find absolute root
        
        if(parent[vertex] == -1){ // till it reaches the absolute root 
            return vertex;
        }
        return parent[vertex] = find(parent[vertex]); // else finds the parent of the parameter passed vertex
        
    }



    public static void main(String[] args) {
        DisjointSet s = new DisjointSet(5);
        s.isCycleDetected(0, 1);
        s.isCycleDetected(0, 3);
        s.isCycleDetected(1, 4);
        s.isCycleDetected(3, 4);


    }
}
