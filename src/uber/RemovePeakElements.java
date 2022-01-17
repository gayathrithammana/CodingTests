package uber;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class RemovePeakElements {

	private static List<Integer> removePeaks(List<Integer> list) {
		List<Integer> result = new ArrayList<>();

		solve(list, result);

		return result;
	}

	public static void solve(List<Integer> list, List<Integer> result) {
		if (list.size() == 2) {
			int first = list.get(0);
			int second = list.get(1);
			if (first > second) {
				result.add(first);
				result.add(second);
			} else {
				result.add(second);
				result.add(first);
			}

			return;
		}

		int[] pair = getMinPair(list);
		if (pair[0] != -1 && pair[1] != -1) {
			list.remove(pair[1]);
			result.add(pair[0]);
		} else {							//if 2, 1, 3, 4 remains in array
			if (list.get(0) > list.get(1)) {
				result.add(list.get(0));
				list.remove(0);
			}
			int n = list.size();
			if (n > 2 && list.get(n - 1) > list.get(n - 2)) {
				result.add(list.get(n - 1));
				list.remove(n - 1);
			}
		}

		solve(list, result);

	}
	
	public static int[] getMinPair(List<Integer> list) {
		int n = list.size();
		PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
		for (int i = 1; i < n - 1; i++) {
			int curr = list.get(i);
			if (curr > list.get(i - 1) && curr > list.get(i + 1)) {
				minHeap.add(new int[] { curr, i });
			}
		}
		
		int[] pair = new int[]{-1, -1};
		if(!minHeap.isEmpty())
			pair = minHeap.peek();
		
		return pair;
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(7);
		list.add(8);
		list.add(5);
		list.add(1);
		list.add(6);
		list.add(3);
		list.add(9);
		list.add(4);
		System.out.println(removePeaks(list));	//6, 8, 7, 5, 9, 2, 4, 3, 1
	}

}
