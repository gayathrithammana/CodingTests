package microsoft.OA;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/discuss/interview-question/1601268/Microsoft-orOA-orInterview-Questions
 * Q2
 *
 */

public class MinFiltersToCutPolutionByHalf {
	
	private static int minimum_number_of_filters_Q2(int[] fact_poll){
	    
	    if(fact_poll == null)
	        return 0;
	    int sum = 0;
	    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));
	    for(int num : fact_poll){
	    	maxHeap.add(num);
	        sum += num;
	    }
	    
	    int minFilters = 0;
	    int tempSum = sum;
	    while(!maxHeap.isEmpty() && tempSum > (sum/2)){
	        int maxP = maxHeap.remove();
	        int currentP = maxP/2;
	        maxHeap.add(currentP);
	        tempSum -= currentP;
	        
	        minFilters++;
	    }
	    return minFilters;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
