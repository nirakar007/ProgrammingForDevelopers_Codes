import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AdjMatrixOriginal {

    int v;
    int graph[][];

    AdjMatrixOriginal(int v) {
        this.v = v;
        graph = new int[v][v];
    }

    void printMatrix() {
        for (int row = 0; row < v; row++) {
            for (int col = 0; col < v; col++) {
                System.out.print(graph[row][col] + " ");
            }
            System.out.println();
        }
    }

    void addEdge(int source, int destination, int w) { // if there is weight passed in the parameter, we put weight as
                                                // graph(source, destination) = weight
        // because this is a undirected graph, both are connected to each other
        graph[source][destination] = w;
        graph[destination][source] = w;

    }

    List<Integer> getAdjNode(int i) {
        List<Integer> adjList = new ArrayList<>();
        for (int j = 0; j < v; j++) { // this parameter's v
            if (graph[v][j] != 0) {
                adjList.add(j);
            }
        }
        return adjList;
    }

    void printGraph() {
        for (int row = 0; row < v; row++) {
            System.out.print(row + " is connected to = ");
            for (int col = 0; col < v; col++) {
                if (graph[row][col] != 0) { // weighted ma kam gardaina "==1" lekhda
                    System.out.print(col + " , ");
                }
            }
            System.out.println();
        }
    }

    // depth first
    // search__________________________________________________________________________________________________________-

    void dfsHelper(int rootnode, boolean[] visited) {
        System.out.println(rootnode);
        visited[rootnode] = true;
        for (int i = 0; i < v; i++) {
            if (graph[rootnode][i] != 0) {
                if (!visited[i]) {
                    dfsHelper(i, visited);
                }
            }
        }
    }

    void dfs(int rootnode) {
        boolean[] visited = new boolean[v];
        dfsHelper(rootnode, visited); // because we need only one array to show visited or not visited
    }

    void dfs2(int rootNode) {
        boolean visited[] = new boolean[v];
        Stack<Integer> stk = new Stack<>();
        stk.push(rootNode);
        while (stk.isEmpty()) {
            int x = stk.peek();
            stk.pop();
            if (!visited[x]) {
                System.out.println(x);
            }
            for (int i = 0; i < v; i++) {
                if (graph[x][1] != 0) {
                    stk.push(i);
                }
            }
        }
    }

    // depth first search application to find
    // distance__________________________________________________________________________________________________________-

    int shortestDistBFS(int source, int destination) {

        // data structure definitions
        Queue queue = new Queue(v);
        boolean visited[] = new boolean[v];
        int dist[] = new int[v];
        int prevpath[] = new int[v];

        for (int i = 0; i < v; i++) {
            dist[i] = Integer.MAX_VALUE; // infinity, because we dont know the distance of the arrays
            prevpath[i] = -1; // path starts from 0 index so, -1 means "not started"

        }

        // updating distance
        dist[source] = 0;
        queue.enqueue(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            int x = queue.dequeue();
            for (int i = 0; i < v; i++) {
                if (graph[x][i] != 0) {
                    if (!visited[i]) { // if the index is not visited
                        if (dist[x] + 1 < dist[i]) { // if the distance of source + 1, (i is the destination), distance
                                                     // of i lai update garne
                            dist[i] = dist[x] + 1;
                            prevpath[i] = x; // esari sabai distance haru update huncha
                        }
                        queue.enqueue(i);
                        visited[i] = true;
                    }
                }

            }

        }

        // print path
        

        return dist[destination]; // distance of destination
    }


    // djikstra's algo __________________________________________________________________________________________________________-


    int dijakstra(int source, int destination){
        int dist[] = new int[v];
        int prevpath[] = new int[v];
        boolean visited[] = new boolean[v];
        
        for(int i=0; i<v; i++){
            dist[i] = Integer.MAX_VALUE;
            prevpath[i] = -1;
        }

        dist[source] = 0;

        // to choose minimum ________________________
        for(int i=0; i<v; i++){
            int u = findMinVertex(dist, visited);
            for(int j=0; j<v; j++){ // j = v = final point
                visited[u] = true;
                if(graph[u][j] != 0){
                    if( dist[u]!=Integer.MAX_VALUE && !visited[j] && dist[u]+graph[u][j] < dist[j] ){
                        dist[j] = dist[u] + graph[u][j];
                        prevpath[j]=u;

                    }
                }
            }
        }
        
        int current = destination;
        Stack<Integer> stk = new Stack<>();
        stk.push(current);
        while (prevpath[current] != -1) {
            current = prevpath[current];
            stk.push(current);
        }
        
        
        // print prevPath() - assignment done
        // printing path
        System.out.println("printing path to destination");
        for(int i=0; i<stk.size(); i++){
            System.out.println(stk.pop());
        }

        
        return dist[destination];
    }

    int findMinVertex(int [] dist, boolean[] visited){
        int minvertex = -1;
        for(int i=0; i<dist.length; i++ ){
            // filtering infinity too
            if(dist[i]!= Integer.MAX_VALUE && minvertex == -1 || dist[i] < dist[minvertex] && !visited[i]){ // the boolean operators in place of if-else
                minvertex=1; 
            }

        }
        return minvertex;
    }

    // TOPOLOICAL SORTING (write it in list)
    void topoSort(){
        int cnt = 0;
        int indegree[] =  new int[v];
        Queue q = new Queue(v);
        // calculate indegree
        for(int i=0; i<v; i++){
            for(int j=0; j<v; j++){
                if(graph[i][j] != 0){ // i is connected to j so j's indegree should increase 
                    indegree[j]++;
                }
            }
        }
        //placing vertices in queue having indegree 0
        for(int i=0; i<indegree.length; i++){
            if(indegree[i]==0){
                q.enqueue(i); // add the vertices into the queue
            }
        }
        while(!q.isEmpty()){
            int x = q.dequeue(); 
            System.out.println(x);
            for(int j=0; j<v; j++){
                if(graph[x][j] != 0){ // this means x and j are connected
                    indegree[j]--;
                    if(indegree[j] == 0){ // yadi indigree 0 cha bhane queue ma add garne, tei add gareko eta
                        q.enqueue(j);
                    }
                }
            }
        }

        if(cnt!=v){
            System.out.println("cycle detected");
            return;
        }
    }




    // main
    // __________________________________________________________________________________________________________-

    public static void main(String[] args) {
        AdjMatrixMST adj = new AdjMatrixMST(6);
        adj.addEdge(0, 1, 4);
        adj.addEdge(0, 3, 2);
        adj.addEdge(1, 2, 20);
        adj.addEdge(2, 5, 100);
        adj.addEdge(0, 5, 100);
        adj.addEdge(3, 1, 1);
        adj.addEdge(3, 4, 5);
        adj.addEdge(4, 5, 5);

        adj.topoSort();

        // adj.printGraph();
        // adj.printMatrix();

        // adj.dfs(0);

    }

}