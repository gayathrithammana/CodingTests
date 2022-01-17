package microsoft;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
	
	private static boolean check(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{put(0,-1);}};;
	    int runningSum = 0;
	    for (int i=0;i<nums.length;i++) {
	    	System.out.println();
	        runningSum += nums[i];
	        System.out.print("before..." + runningSum + "...");
	        if (k != 0) runningSum %= k; 
	        Integer prev = map.get(runningSum);
	        System.out.print(runningSum);
	        if (prev != null) {
	            if (i - prev > 1) return true;
	        }
	        else map.put(runningSum, i);
	    }
	    return false;
	}

	public static void main(String[] args) {
		System.out.println(check(new int[] {23, 2, 4, 6, 7}, 6));
	}

}
