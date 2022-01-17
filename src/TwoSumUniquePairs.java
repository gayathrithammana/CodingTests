import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/discuss/interview-question/372434
 * https://algo.monster/problems/two_sum_unique_pairs
 * https://www.geeksforgeeks.org/count-distinct-pairs-with-given-sum/
 *
 */
public class TwoSumUniquePairs {
	
	private static int countPairs(int[] arr, int target) {
		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		for(int num : arr)
			freqMap.put(num, freqMap.getOrDefault(num, 1) + 1);
		
		int count = 0;
		for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
			int num = entry.getKey();
			//we need below if condition,cause we are returning count/2.if number is 6 and target is 12, 
			//we traverse map only once and 1/2 = 0. in such cases we need to increment count by 2
			if(2 * num == target) {			
				if(freqMap.get(num) > 1)
					count += 2;
			}
			else {
				if(freqMap.containsKey(target - num))
					count++;
			}
			
		}
		count = count / 2;
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(countPairs(new int[] {1, 1, 2, 45, 46, 46}, 47));	//2
		System.out.println(countPairs(new int[] {1, 1}, 2));	//1
	}
}
