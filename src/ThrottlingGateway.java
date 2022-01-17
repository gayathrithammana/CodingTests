
/**
 * https://leetcode.com/discuss/interview-question/1079582/Amazon-OA-Part-2-Interview-Questions
 * https://leetcode.com/discuss/interview-question/819577/Throttling-Gateway-Hackerrank
 * https://aonecode.com/amazon-online-assessment-throttling-gateway
 * 
 * at each window check if values of requests fall into any of the categories
 * Rule1 : any given second cannot exceed 3
 * Rule2 : any given 10-second period cannot exceed 20
 * Rule3 : any given 60-second period cannot exceed 60
 * 
 * 1. every 3 requests can be processed easily as per rule1
 * 2. we are at 4th request 
 *     - if the value is diff from 1st element we dont need to check anything
 *     - else if it is same [1,1,1,1] we need to drop as any second it can process only 3 requests
 *     		increase the drop count
 * 3. we are at 20th request
 * 	   - if the diff of current and previous 20th element should be < 10
 *     - else increase the drop count
 * 4. we are at 60th request
 * 	   - if the diff of current and previous 60th element should be < 60
 *     - else increase the drop count
 */
public class ThrottlingGateway {
	
	private static int countDrop(int[] arr) {
		int dropCount = 0;
		for(int i=0;i<arr.length;i++) {
			if(i > 2 && (arr[i] == arr[i-3]))
				dropCount++;
			else if(i > 19 && ((arr[i] - arr[i-20]) < 10))
				dropCount++;
			else if(i > 59 && ((arr[i] - arr[i-59]) < 60))
				dropCount++;
		}
		return dropCount;
	}
	
	public static void main(String[] args) {
		System.out.println(countDrop(new int[] {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 11, 11, 11, 11})); //7
		System.out.println(countDrop(new int[] {1, 1, 1, 1, 2}));
	}
}

	

