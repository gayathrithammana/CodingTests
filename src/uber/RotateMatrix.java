package uber;

/**
 * https://leetcode.com/discuss/interview-question/1066383/Uber-OA
 * 
 * https://leetcode.com/problems/rotate-image/
 * 48. Rotate Image
 * https://www.youtube.com/watch?v=SA867FvqHrM
 * 
 */

public class RotateMatrix {
	
	private static void rotate(int[][] arr) {
		int n = arr.length;
		//transpose rows by columns
		for(int i=0;i<n;i++) {	//row
			for(int j=i;j<n;j++) {	//column
				if(i != j && i != n-1 && j != n-1) {	//if diagnoal is fixed
					int temp = arr[i][j];
					arr[i][j] = arr[j][i];
					arr[j][i] = temp;
				}
			}
		}
		
		//swap elements in each row 
		for(int i=0;i<n;i++) {	//row
			for(int j=0;j<(n/2);j++) {	//column
				if(i != j && i != n-1 && j != n-1) {	//if diagnoal is fixed
					int temp = arr[i][j];
					arr[i][j] = arr[i][n-j-1];
					arr[i][n-j-1] = temp;
				}
			}
		}
		
	}

	public static void main(String[] args) {
		int[][] arr =new int[][] {{1,2,3}, {4,5,6}, {7,8,9}}; 
		//in case k rotations
		int k = 6;
		k = k % 4;
		for(int i=0;i<k;i++) {
			rotate(arr);
		}
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

}
