package uber;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/discuss/interview-question/1049739/Uber-or-Quora-OA
 * https://leetcode.com/discuss/interview-question/1104717/Quora-or-OA-CodeSignal-or-Feb-2021
 */

public class RhombicArea {
	
	private static List<Integer> solve(int radius, int[][] matrix) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();	//min PQ
		radius--;
		for(int i = 0; i + 2 * radius < matrix.length; i++) {
			for(int j = 0; j + 2 * radius < matrix[i].length; j++) {
				int sum = rhombusArea(matrix, i + radius, j + radius, radius);
				if(!pq.contains(sum)) {		// distinct
					pq.add(sum);
					if(pq.size() > 3) {		// maintain only top 3
						pq.poll();
					}
				}
			}
		}
		List<Integer> res = new ArrayList<>(3);
		while(!pq.isEmpty()) {
			res.add(pq.poll());
		}
		return res;
	}

	private static int rhombusArea(int[][] matrix, int i, int j, int radius) {
		if(radius == 0) 
			return matrix[i][j];
		
		int sum = - (matrix[i][j - radius] + 
				     matrix[i - radius][j] + 
				     matrix[i][j + radius] + 
				     matrix[i + radius][j]);	// corners get double counted in following loops
		// 1 loop per side of rhombus: initialize row, col with a corner value and use ++,++ or ++,-- or --,++ or --,-- to stay on it
		int row = i;
		int col = j - radius;
		for(int t = 0; t <= radius; t++) {
			sum += matrix[row--][col++];	//Bottom to Top - 13 8 3 
		}
		
		row = i - radius;
		col = j;
		for(int t = 0; t <= radius; t++) {
			sum += matrix[row++][col++];	//Top to Bottom - 3 10 17
		}
		
		row = i;
		col = j + radius;
		for(int t = 0; t <= radius; t++) {
			sum += matrix[row++][col--];	//Top to Bottom - 17 22 27
		}
		
		row = i + radius;
		col = j;
		for(int t = 0; t <= radius; t++) {
			sum += matrix[row--][col--];	//Bottom to Top - 27 20 13
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(solve(3,new int[][] {
				{1,2,3,4,5,6}, 
				{7,8,9,10,11,12}, 
				{13,14,15,16,17,18},
				{19,20,21,22,23,24},
				{25,26,27,28,29,30}}));
	}

}
