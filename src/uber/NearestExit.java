package uber;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/discuss/interview-question/1147715/Uber-Coding-questions-OA
 * Similiar problem: 1091. Shortest Path in Binary Matrix
 * 
 * BFS
 */
public class NearestExit {
	
	public static void findNear(int[][] arr) {
		int m = arr.length;
		int n = arr[0].length;
		boolean[][] seen = new boolean[m][n];
		seen[0][0] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0});
		
		int[] position = null;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				position = q.poll();
				
				if(position[0] == m-1 || position[1] == n-1)	//assuming last row and last column are exists
					break;
				
				checkAllDirections(arr, q, position, seen);
			}
		}
				
		
		System.out.println(position[0] + "..."+position[1]);
	}

	private static void checkAllDirections(int[][] arr, Queue<int[]> queue, int[] position, boolean[][] seen) {
		int i = position[0];
		int j = position[1];
		
		if(checkBounds(i, j + 1, arr.length, arr[0].length) && arr[i][j+1] == 0 && !seen[i][j+1]) {
			seen[i][j+1] = true;
			queue.add(new int[] {i, j + 1});
		}
		
		if(checkBounds(i, j - 1, arr.length, arr[0].length) && arr[i][j-1] == 0 && !seen[i][j-1]) {
			seen[i][j-1] = true;
			queue.add(new int[] {i, j - 1});
		}
		
		if(checkBounds(i + 1, j, arr.length, arr[0].length) && arr[i+1][j] == 0 && !seen[i+1][j]) {
			seen[i+1][j] = true;
			queue.add(new int[] {i + 1, j});
		}
		
		if(checkBounds(i - 1, j, arr.length, arr[0].length) && arr[i-1][j] == 0 && !seen[i-1][j]) {
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
		int[][] a = new int[][]{{1,0,0,1,1,1},
								{1,0,0,0,1,1},
								{1,1,1,0,1,1},
								{1,1,1,0,1,1},
								{0,1,0,0,0,0},
								{0,0,0,1,1,1}};
								   
		findNear(a);
	}

}
