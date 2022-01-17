package amazon.dfs;
import java.util.Vector;

/**
 * https://leetcode.com/discuss/interview-question/1001809/AMAZON-or-OA-or-Matrix-challenge
 * Similar to
 * https://www.geeksforgeeks.org/rat-in-a-maze-problem-when-movement-in-all-possible-directions-is-allowed/?ref=rp
 *
 * a 2D matrix of 0 and 1's of some arbitrary size, and determine if a path of 1's exists from 
 * the top-left of the matrix to the bottom-right of the matrix while moving only in the directions: 
 * up, down, left, and right. If a path exists your program should return the string true, 
 * otherwise your program should return the number of locations in the matrix where 
 * if a single 0 is replaced with a 1, a path of 1's will be created successfully.
 * If a path does not exist and you cannot create a path by changing a single location in the matrix 
 * from a 0 to a 1, then your program should return the string not possible. 
 * 
 * For example: if strArr is ["11100", "10011", "10101", "10011"]
 * 
 * For the input above, a path of 1's from the top-left to the bottom-right does not exist. 
 * But, we can change a 0 to a 1 in 2 places in the matrix, namely at locations: [0,3] or [1,2]. 
 * So for this input your program should return 2. 
 * The top-left and bottom-right of the input matrix will always be 1's.
 * 
 * This problem is similar to printall paths to reach from top-left to bottom-right
 * 
 * DFS
 */

public class MatrixChallenge {
	
	static Vector<String> possiblePaths = new Vector<>();
	static String path = "";

	public static void dfs(int i, int j, int m, int n, char[][] grid, boolean[][] visited) {
		
		if(!checkBounds(i, j, m, n, grid, visited))
			return;
		
		if (i == m - 1 && j == n - 1) {
			possiblePaths.add(path);
			return;
		}

		visited[i][j] = true;
		
		int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		for(int k=0;k<4;k++){
            i += dir[k][0];
            j += dir[k][1];
            
            if(checkBounds(i, j, m, n, grid, visited)) {
            	path += grid[i][j];
    			dfs(i, j, m, n, grid, visited);
    			path = path.substring(0, path.length() - 1);
            }
            
        }

		visited[i][j] = false;
	}
	
	private static boolean checkBounds(int i, int j, int m, int n, char[][] grid, boolean[][] visited) {
		if(!(i >= 0 && i < m && j >= 0 && j < n) || visited[i][j])
			return false;
		
		if(grid[i][j] == '0') {
			if(path.indexOf('0') > -1) {	//when 0 is already present in path
				if(path.indexOf('0') != path.lastIndexOf('0'))	//more than one 0 present
					return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
//	    char[][] grid = new char[][] { { '1', '1', '1', '0', '0' }, 
//									   { '1', '0', '0', '1', '1' },
//									   { '1', '0', '1', '0', '1' }, 
//									   { '1', '0', '0', '1', '1' } };	//2
//	    char[][] grid = new char[][] { { '1', '0', '0', '0', '0' }, 
//		   							   { '1', '1', '0', '1', '1' },
//									   { '1', '0', '1', '0', '1' }, 
//									   { '1', '1', '0', '0', '1' } };	//1
		char[][] grid = new char[][] { { '1', '0', '0', '0', '0', '0', '1' }, 
				   					   { '1', '0', '0', '1', '1', '1', '1' },
									   { '1', '0', '1', '0', '1', '0', '1' }}; 

		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		
		dfs(0, 0, m, n, grid, visited);
		System.out.println(possiblePaths.size());
		
	}

}
