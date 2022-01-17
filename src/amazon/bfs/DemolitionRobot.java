package amazon.bfs;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/discuss/interview-question/1033264/Amazon-or-OA-or-1-year-Experienced-for-SDE1
 * https://algo.monster/problems/move_the_obstacle
 * 
 * Given a matrix with values 0 (trenches), 1 (flat) ,9 (obstacle) 
 * you have to find minimum distance to reach 9 (obstacle). 
 * 
 * If not possible then return -1.
 * The demolition robot must start at the top left corner of the matrix, which is always flat, 
 * and can move on block up,down,right,left.
 * The demolition robot cannot enter 0 trenches and cannot leave the matrix.
 * 
 * BFS
 * 
 * 2D matrix - Similar to Rotten Oranges
 */
public class DemolitionRobot {
	
	private static int minSteps(int[][] arr) {
		int steps = 0;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0});
		int m = arr.length;
		int n = arr[0].length;
		boolean[][] seen = new boolean[m][n];
        seen[0][0] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] position = q.poll();
				int x = position[0];
				int y = position[1];
				
				if(arr[x][y] == 9)
					return steps;
				
				checkAllDirections(arr, q, position, seen);	//traverse all neighbours
			}
			steps++;
		}
		
		return -1;
	}

	private static void checkAllDirections(int[][] arr, Queue<int[]> queue, int[] position, boolean[][] seen) {
		int i = position[0];
		int j = position[1];
		
		//TO-DO: dont fully understand arr[i][j+1] != 1
		//as per my understanding it is required to check arr[i][j+1] != 1, cause robot cannot enter 0 trenches and cannot leave the matrix
		//which means that it must have a trench
		if(checkBounds(i, j + 1, arr.length, arr[0].length) && arr[i][j+1] != 1 && !seen[i][j+1]) {
			seen[i][j+1] = true;
			queue.add(new int[] {i, j + 1});
		}
		
		if(checkBounds(i, j - 1, arr.length, arr[0].length) && arr[i][j-1] != 1 && !seen[i][j-1]) {
			seen[i][j-1] = true;
			queue.add(new int[] {i, j - 1});
		}
		
		if(checkBounds(i + 1, j, arr.length, arr[0].length) && arr[i+1][j] != 1 && !seen[i+1][j]) {
			seen[i+1][j] = true;
			queue.add(new int[] {i + 1, j});
		}
		
		if(checkBounds(i - 1, j, arr.length, arr[0].length) && arr[i-1][j] != 1&& !seen[i-1][j]) {
			seen[i-1][j] = true;
			queue.add(new int[] {i - 1, j});
		}
	}
	
	private static boolean checkBounds(int i, int j, int rows, int columns) {
		if(i >= 0 && i < rows && j >= 0 && j < columns)
			return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(minSteps(new int[][] {{1, 0, 0}, 
												 {1, 0, 0}, 
												 {1, 9, 1}}));	//3
		System.out.println(minSteps(new int[][] {{0,1,0,0,0},
            									 {0,0,0,0,0},
									             {0,1,0,0,0},
									             {0,1,0,9,0},
									             {0,0,0,0,0}}));	//6
		System.out.println(minSteps(new int[][] {{1,0,0},
			 									 {1,0,9},
										         {1,9,1}}));		//3
	}

}
