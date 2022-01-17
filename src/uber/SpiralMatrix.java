package uber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/discuss/interview-question/1064334/Uber-Oa
 * https://www.interviewbit.com/problems/spiral-order-matrix-i/
 *
 */

public class SpiralMatrix {

	private static List<Integer> printSprial(int[][] arr) {

		int m = arr.length;
		int n = arr[0].length;
		int dir = 0;
		int T = 0;
		int L = 0;
		int B = m - 1;
		int R = n - 1;
		List<Integer> result = new ArrayList<>();
		while (T <= B && L <= R) {
			if (dir == 0) {
				List<Integer> list = new ArrayList<>();
				for (int i = L; i <= R; i++) {
					list.add(arr[T][i]);

				}
				if (T == 0) { // for borders add sorted manner
					Collections.sort(list);
				}

				result.addAll(list);

				T++;
				dir = 1;
			} else if (dir == 1) {
				List<Integer> list = new ArrayList<>();
				for (int i = T; i <= B; i++) {
					list.add(arr[i][R]);
				}
				if (R == n - 1) { // for borders add sorted manner
					Collections.sort(list);
				}

				result.addAll(list);

				R--;
				dir = 2;
			} else if (dir == 2) {
				List<Integer> list = new ArrayList<>();
				for (int i = R; i >= L; i--) {
					list.add(arr[B][i]);
				}
				if (B == m-1) { // for borders add sorted manner
					Collections.sort(list);
				}
				result.addAll(list);
				
				B--;
				dir = 3;
			} else {
				List<Integer> list = new ArrayList<>();
				for (int i = B; i >= T; i--) {
					list.add(arr[i][L]);
				}
				if (L == 0) { // for borders add sorted manner
					Collections.sort(list);
				}
				result.addAll(list);
				
				L++;
				dir = 0;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(printSprial(new int[][] { { 1, 3, 2 }, { 4, 5, 6 }, { 7, 8, 9 } }));	//[1, 2, 3, 6, 9, 7, 8, 4, 5]
	}

}
