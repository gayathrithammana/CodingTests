package amazon.dfs;

/**
 * https://leetcode.com/discuss/interview-question/1101937/Amazon-or-SDE-New-grad-or-Seattle-Area-Offer 
 * Leetcode: 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 * 
 * DFS
 */
public class NumberOfIslands {
	
	public static int numOfIslands(char[][] grid) {
		int count = 0;
		int n = grid.length;
		int m = grid[0].length;
		
		if(n == 0)
			return 0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(grid[i][j] == '1') {
					DFS(grid, i, j, n, m);
					count++;
				}
					
			}
		}
		
		return count;
		
	}

	private static void DFS(char[][] grid, int i, int j, int n, int m) {
		if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1')
			return;
		
		grid[i][j] = '0';
		DFS(grid, i+1, j, n, m);
		DFS(grid, i-1, j, n, m);
		DFS(grid, i, j+1, n, m);
		DFS(grid, i, j-1, n, m);
	}

	public static void main(String[] args) {
		System.out.println(numOfIslands(new char[][] {{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}}));
		System.out.println(numOfIslands(new char[][] {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}}));
	}

}
