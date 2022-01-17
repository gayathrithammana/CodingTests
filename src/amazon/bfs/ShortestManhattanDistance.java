package amazon.bfs;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/shortest-distance-from-all-buildings/
 * Leetcode 317. Shortest Distance from All Buildings
 * https://leetcode.com/problems/shortest-distance-from-all-buildings/discuss/76891/Java-solution-with-explanation-and-time-complexity-analysis
 * 
 * https://leetcode.com/discuss/interview-question/1032186/Amazon-oror-Onsite-oror-get-a-shortest-manhattan-distance-in-a-given-matrix
 * get a shortest manhattan distance in a given matrix
 * 
 * BFS
 * 
 */

public class ShortestManhattanDistance {
	public static int shortestDistance(int[][] grid) {
        if (grid == null || grid[0].length == 0) 
        	return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        int distance[][] = new int[m][n];
        int reach[][] = new int[m][n];
        
        int totalBuildings = 0;
        for(int i=0;i<m;i++) {
        	for(int j=0;j<n;j++) {
        		//if it is building
        		if(grid[i][j] == 1) {
        			
        			totalBuildings++;
        			
        			//BFS
        	        Queue<int[]> q = new LinkedList<>();
        	        q.add(new int[] {i, j});
        	        boolean seen[][] = new boolean[m][n];
        	        int level = 1;
        	        while(!q.isEmpty()) {
        	        	int size = q.size();
        	        	for(int k=0;k<size;k++) {
        	        		int[] currentPosition = q.poll();
        	        		
        	        		checkAllDirections(q, currentPosition, grid, seen, distance, reach, level);
        	        	}
        	        	level++;
        	        }
        	        
        		}
        	}
        }
        
        int minDistance = Integer.MAX_VALUE;
        for(int i=0;i<m;i++) {
        	for(int j=0;j<n;j++) {
        		if(grid[i][j] == 0 && reach[i][j] == totalBuildings) {
        			minDistance = Math.min(distance[i][j], minDistance);
        		}
        	}
        }
        
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
	
	private static void checkAllDirections(Queue<int[]> q, int[] position, int[][] grid, boolean[][] seen, int[][] distance,
			int[][] reach, int level) {
		int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		for(int i=0;i<4;i++){
            int x = dir[i][0] + position[0];
            int y = dir[i][1] + position[1];
            
            if(checkBounds(x, y, grid.length, grid[0].length) && grid[x][y] == 0 && !seen[x][y]) {
    			q.add(new int[] {x, y});
    			seen[x][y] = true;
    			
    			distance[x][y] += level;
    			reach[x][y]++;
            }
        }
	}
	
	private static boolean checkBounds(int i, int j, int rows, int columns) {
		if(i >= 0 && i < rows && j >= 0 && j < columns)
			return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(shortestDistance(new int[][] {{1,0,2,0,1}, {0,0,0,0,0}, {0,0,1,0,0}}));	//7
		/**
		 * 1 0 2 0 1
		 * 0 0 0 0 0
		 * 0 0 1 0 0
		 * 
		 * distance[][]
		 * 0  9 0 9 0
		 * 9  8 7 8 9 
		 * 10 9 0 9 10
		 * 
		 * reach[][]
		 * 0 3 0 3 0
		 * 3 3 3 3 3
		 * 3 3 0 3 3
		 * 
		 */
	}

}
