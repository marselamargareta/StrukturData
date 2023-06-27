import java.util.*;

class Graph {
    private int V;
    private LinkedList<Integer>[] adjacencyList;

    public Graph(int V) {
        this.V = V;
        adjacencyList = new LinkedList[V + 1];
        for (int i = 1; i <= V; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    public void DFS(int startVertex) {
        boolean[] visited = new boolean[V + 1];
        DFSUtil(startVertex, visited);
    }

    private void DFSUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbor : adjacencyList[vertex]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    public void BFS(int startVertex) {
        boolean[] visited = new boolean[V + 1];
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int neighbor : adjacencyList[vertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }
}

public class GraphTraversal {
    public static void main(String[] args) {
        Graph graph = new Graph(11);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 1);
        graph.addEdge(2, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 3);
        graph.addEdge(5, 7);
        graph.addEdge(5, 9);
        graph.addEdge(6, 7);
        graph.addEdge(7, 6);
        graph.addEdge(7, 11);
        graph.addEdge(8, 9);
        graph.addEdge(8, 11);
        graph.addEdge(9, 5);
        graph.addEdge(9, 8);
        graph.addEdge(11, 7);
        graph.addEdge(11, 10);

        clearTerminal();

        System.out.println("Depth-First Search (DFS) Traversal:");
        graph.DFS(1);

        System.out.println("\n\nBreadth-First Search (BFS) Traversal:");
        graph.BFS(1);
    }

    private static void clearTerminal() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Exception handling if clearing the terminal fails
        }
    }
}
