import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {

    private int v; // Number of vertices
    private LinkedList<Integer> adjList[];

    public TopologicalSort(int v) {
        this.v = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Add directed edge from u to v
    public void addEdge(int u, int v) {
        adjList[u].add(v);
    }

    // Recursive function to perform topological sort starting from a given vertex
    private void topologicalSortUtil(int vertex, boolean visited[], Stack<Integer> stack) {
        // Mark the current node as visited
        visited[vertex] = true;

        // Recur for all the vertices adjacent to this vertex
        for (Integer neighbor : adjList[vertex]) {
            if (!visited[neighbor]) {
                topologicalSortUtil(neighbor, visited, stack);
            }
        }

        // Push current vertex to stack which stores the result
        stack.push(vertex);
    }

    // Perform topological sort
    public void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[v];

        // Call the recursive helper function for all vertices
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        // Print the contents of the stack, which represents the topological order
        System.out.println("Topological Sort:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        TopologicalSort graph = new TopologicalSort(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        graph.topologicalSort();
    }
}
