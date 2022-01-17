package microsoft.OA;

/**
 * https://leetcode.com/discuss/interview-question/1601268/Microsoft-orOA-orInterview-Questions
 * Q3
 * https://leetcode.com/problems/minimum-time-to-make-rope-colorful/
 */
public class MinDeletionsToAvoidRepLetters {
	
	public static int minCost(String s, int[] cost) {
		int n = s.length();
		int sum = 0;
		int maxTotalCosts = 0;
		
		for(int i=0;i<n;i++)
			sum += cost[i];
		
		for(int i=0;i<n;i++){
			int maxCost = cost[i];
			while(i+1 < n && s.charAt(i) == s.charAt(i+1)){
				maxCost = Math.max(maxCost,	cost[i+1]);
				i++;
			}

			maxTotalCosts += maxCost;
		}
		
		return sum - maxTotalCosts;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
