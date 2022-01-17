
/**
 * https://leetcode.com/discuss/interview-question/1072308/Amazon-SDE-Coding-Question.-Thought
 * 
 * Minimum Processing Time
 * task that takes more time need to be assigned to the processor that starts early(less process time) 
 *
 */
public class MinimumProcessingTime {
	
	public static int minTime(int n, int[] processorTimes, int[] taskTimes) {
		int maxTaskTime = taskTimes[0];
		for(int task : taskTimes)
			maxTaskTime = Math.max(task, maxTaskTime);
		
		//this max task need to be assigned to min/early processor
		int minProcessor = processorTimes[0];
		for(int processor : processorTimes)
			minProcessor = Math.min(processor, minProcessor);
		
		return maxTaskTime + minProcessor;
		
	}

	public static void main(String[] args) {
		System.out.println(minTime(2, new int[] {8, 10}, new int[] {2, 2, 3, 1, 8, 7, 4, 5}));	//16
	}

}
