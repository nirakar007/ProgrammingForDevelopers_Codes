import java.util.LinkedList;
import java.util.Queue;

public class AdjList {

    int v;
    LinkedList<Integer> list[];
    
    AdjList(int v) {
        this.v = v;
        list = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            list[i] = new LinkedList<>();
        }
    }

    // Method to add an edge between source and destination
    void addEdge(int source, int destination) {
        list[source].add(destination);
        list[destination].add(source);
    }

    // Method to print the adjacency list representation of the graph
    void printGraph() {
        for (int i = 0; i < v; i++) {
            System.out.print(i + " is connected to =");
            for (Integer neighbor : list[i]) {
                System.out.print(neighbor + ", ");
            }
            System.out.println();
        }
    }
    
    // Method to get nodes adjacent to a given node
    void getAdjNode(int node) {
        System.out.print(node + " is connected to =");
        for (Integer neighbor : list[node]) {
            System.out.print(neighbor + ", ");
        }
        System.out.println();
    }
    
    // Method to perform Breadth-First Search starting from a given root node
    void BFS(int rootNode) {
        boolean[] visited = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        q.add(rootNode);
        visited[rootNode] = true;
        
        while (!q.isEmpty()) {
            int x = q.poll();
            System.out.println(x);
            
            // Explore neighbors of the current node
            for (int neighbor : list[x]) {
                if (!visited[neighbor]) {
                    q.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        AdjList adj = new AdjList(5);
        adj.addEdge(0, 1);
        adj.addEdge(0, 2);
        adj.addEdge(0, 4);
        adj.addEdge(2, 3);
        adj.addEdge(1, 4);
        adj.addEdge(4, 3);
        adj.printGraph();
        
        System.out.println("Nodes adjacent to node 0:");
        adj.getAdjNode(0);
        
        System.out.println("BFS traversal starting from node 0:");
        adj.BFS(0);
    }
}
// public class AdjList {

//     int v;
//     LinkedList list[];

//     AdjList(int v) {
//         this.v = v;
//         list = new LinkedList[v];
//         for (int i = 0; i < v; i++) {
//             list[i] = new LinkedList();
//         }
//     }

//     void addEdge(int source, int destination) {
//         list[source].addNode(destination); // == list[0]
//         list[destination].addNode(source);
//     }

//     void printGraph() {
//         for (int i = 0; i < v; i++) {
//             System.out.print(i + " is connected to =");
//             LinkedList.Node current = list[i].head; // head ko address rakhne thau
//             while (current != null) {
//                 System.out.print(current.data + ", ");
//                 current = current.next;
//             }
//             System.out.println();

//         }
//     }

//     void getAdjNode() { // *assignment*

//     }

//     void BFS(int rootNode) {
//         // make an array to verify if visited or not bool arr
//         boolean[] visited = new boolean[v];
//         Queue q = new Queue(v);
//         q.enqueue(rootNode);
//         visited[rootNode] = true;

//         while (!q.isEmpty()) {
//             int x = q.dequeue();
//             System.out.println(x);

//             for (int i = 0; i < v; i++) {
//                 if (graph[x][i] != 0) {
//                     if (!visited[i]) { //import java.util.Queue;

//                         q.enqueue(1);
//                         visited[i] = true;

//                     }
//                 }
//             }

//         }

//     }

//     public static void main(String[] args) {
//         AdjList adj = new AdjList(5);
//         adj.addEdge(0, 1);
//         adj.addEdge(0, 2);
//         adj.addEdge(0, 4);
//         adj.addEdge(2, 3);
//         adj.addEdge(1, 4);
//         adj.addEdge(4, 3);
//         adj.printGraph();
//         System.out.println("traversing");
        

//     }
// }
