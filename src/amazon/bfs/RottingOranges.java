package amazon.bfs;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/discuss/interview-question/1079508/Amazon-Online-Assessment-or-Europe-or-2020
 * Leetcode 994. Rotting Oranges
 * 
 *  0 representing an empty cell,
 *  1 representing a fresh orange
 *  2 representing a rotten orange.
 *  
 *  
 *  Problem2: Return an integer representing the minimun number of hours required to send the file to all the available servers. 
 *  
 * BFS
 */

public class RottingOranges {
	
	public static int orangesRotting(int[][] grid) {
        //Step1: count fresh oranges and save rotten oranges
		Queue<int[]> queue = new LinkedList<>();
		
		int fresh = 0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j] == 1)
					fresh++;
				else if(grid[i][j] == 2)
					queue.offer(new int[] {i, j});
					
			}
		}
		
		if(fresh == 0)
			return 0;
		
		//Step2: count level while doing bfs
		
		int level = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0;i<size;i++) {
				int[] currentPosition = queue.poll();
				fresh -= rottenAllDirections(grid, queue, currentPosition);
			}
			level++;
		}
		
		return fresh == 0 ? (level - 1) : -1; 
    }
	
	public static int rottenAllDirections(int[][] grid, Queue<int[]> queue, int[] position) {
		int countRotten = 0;
		int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		for(int k=0;k<4;k++){
            int x = dir[k][0] + position[0];
            int y = dir[k][1] + position[1];
            
            if(checkBounds(x, y, grid.length, grid[0].length) && grid[x][y] == 1 ) {
            	grid[x][y] = 2;
    			queue.add(new int[] {x, y});
    			countRotten++;
            }
            
        }
		
		return countRotten;
	}

	private static boolean checkBounds(int i, int j, int rows, int columns) {
		if(i >= 0 && i < rows && j >= 0 && j < columns)
			return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(orangesRotting(new int[][]{{2,1,1}, {1,1,0}, {0,1,1}}));	//4
		System.out.println(orangesRotting(new int[][]{{2,1,1}, {0,1,1}, {1,0,1}}));	//-1
		System.out.println(orangesRotting(new int[][]{{0,2}}));	//0
	}

}
