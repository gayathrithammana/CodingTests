package googleCodingCompetition;
import java.util.Scanner;
public class Solution {
	 private static final Scanner in = new Scanner(System.in);
	public static int findCost(int N, int[] arr) {
		int cost = 0;
		for(int i=1;i<N-1;i++) {
			int j = findMinPosition(i, N, arr);
			reverse(i, j, arr);
			cost += j-i+1;
		}
		return cost;
	}
	
	public static void reverse(int start, int end, int[] arr) {
		for(int i=start;i<end/2;i++) {
			int temp = arr[i];
			arr[i] = arr[end-i-1];
			arr[end-i-1] = temp;
		}
	}
	
	public static int findMinPosition(int i, int N, int[] arr) {
		int min = arr[i];
		int position = i;
		for(int j=i;j<N;j++) {
			if(arr[j] < min) {
				min = arr[j];
				position = j;
			}
		}
		return position+1;
	}

	public static void main(String[] args) {
//		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int[] arr = new int[n];
//			in.nextLine();
			for (int j = 0; j < n; j++) {
				int arrItem = in.nextInt();
	            arr[j] = arrItem;
			}
			System.out.println("Case #" + (i) + ": " + findCost(n, arr));
		}
		in.close();
	}

}
