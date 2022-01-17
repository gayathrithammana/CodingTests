package amazon.dfs;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/discuss/interview-question/1061306/Amazon-or-OA-(SDE-experienced)-Canada-or-Cloud-Front-Caching
 * https://leetcode.com/discuss/interview-question/1168802/Amazon-or-OA
 * https://aonecode.com/oa-cloudfront-caching
 * 
 * DFS
 */
public class CloudFrontCaching {

	public static void dfs(int v, boolean[] visited, Graph graph, List<Integer> connectedList)
    {
        visited[v] = true;
        System.out.print(v+1 + " ");
        connectedList.add(v);
        for (int x : graph.getAdjacenyList(v)) {
            if (!visited[x])
            	dfs(x, visited, graph, connectedList);
        }
    }

	private static int calConnected(int N, Graph graph) {
        boolean[] visited = new boolean[N];
        int ceilSum = 0;
        int singleNodes = 0;
        for (int i=0;i<N;i++) {
            if (!visited[i]) {
            	if(graph.getAdjacenyList(i).size() > 0) {
	                List<Integer> connectedList = new ArrayList<Integer>();
            		dfs(i, visited, graph, connectedList);
	                System.out.println(connectedList.size());
	                ceilSum += Math.ceil(Math.sqrt(connectedList.size()));
            	} else{
            		singleNodes++;
            	}
            }
        }
        
        ceilSum += singleNodes;
		return ceilSum;
	}
	
	public static int solve(int N, String[] edges) {
		Graph graph = new Graph(N);
		
		for (int i = 0; i < edges.length; ++i) {
			String[] srcDest = edges[i].split(" ");
			int src = Integer.parseInt(srcDest[0]) - 1;
			int dest = Integer.parseInt(srcDest[1]) - 1;
			
			graph.addEdge(src, dest);
		}

		return calConnected(N, graph);
	}

	public static void main(String[] args) {
		System.out.println(solve(10, new String[] { "1 2", "1 3", "2 4", "3 5", "7 8"}));
		System.out.println(solve(4, new String[] { "1 2", "1 4"}));
		System.out.println(solve(8, new String[] { "8 1", "5 8", "7 3", "8 6"}));
	}

}
