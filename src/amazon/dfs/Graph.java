package amazon.dfs;
import java.util.ArrayList;

public class Graph {
	int V; // number of vertices
	ArrayList<ArrayList<Integer> > adjListArray;

	Graph(int V) {
		this.V = V;
        // define the size of array as
        // number of vertices
        adjListArray = new ArrayList<>();
 
        // Create a new list for each vertex
        // such that adjacent nodes can be stored
 
        for (int i = 0; i < V; i++) {
            adjListArray.add(i, new ArrayList<>());
        }
	}

	// Function to add an edge into the graph
	void addEdge(int src, int dest)
    {
        // Add an edge from src to dest.
        adjListArray.get(src).add(dest);
 
        // Since graph is undirected, add an edge from dest
        // to src also
        adjListArray.get(dest).add(src);
    }
	
	ArrayList<Integer> getAdjacenyList(int s){
		return this.adjListArray.get(s);
	}
	
}
