package uber;

import java.util.Stack;

/**
 * https://leetcode.com/discuss/interview-question/1096099/uber-codesignal
 */

public class DriverIncentives {
	
	private static int find(int[] arr) {
		int[] smallestLeft = getSmallestToLeft(arr);
		int[] smallestRight = getSmallestToRight(arr);
		
		int n = arr.length;
		int[] sum = new int[n];
		sum[0] = arr[0];
		for(int i=1;i<n;i++)
			sum[i] = sum[i-1] + arr[i];
		
		int maxIncentive = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			int leftValue = (smallestLeft[i] == -1) ? 0 : sum[smallestLeft[i]];
			int rightValue = (smallestRight[i] == -1) ? sum[n-1] : sum[smallestRight[i] - 1];
			int currentSum = rightValue - leftValue;
			maxIncentive = Math.max(maxIncentive, currentSum * arr[i]);
		}
		
		
		return maxIncentive;
	}

	private static int[] getSmallestToLeft(int[] arr) {
		int n = arr.length;
		int[] result = new int[n];
		Stack<Integer> s = new Stack<>();
		
		for(int i=0;i<n;i++) {
			int currentElem = arr[i];
			if(s.isEmpty())
				result[i] = -1;
			else if(!s.isEmpty() && arr[s.peek()] < currentElem)
				result[i] = s.peek();
			else if(!s.isEmpty() && arr[s.peek()] >= currentElem) {
				
				while(!s.isEmpty() && arr[s.peek()] >= currentElem)
					s.pop();
				
				if(s.isEmpty())
					result[i] = -1;
				else
					result[i] = s.peek();
			}
			
			s.push(i);
			
		}
		return result;
	}
	
	private static int[] getSmallestToRight(int[] arr) {
		int n = arr.length;
		int[] result = new int[n];
		Stack<Integer> s = new Stack<>();
		
		for(int i=n-1;i>=0;i--) {
			int currentElem = arr[i];
			if(s.isEmpty())
				result[i] = -1;
			else if(!s.isEmpty() && arr[s.peek()] < currentElem)
				result[i] = s.peek();
			else if(!s.isEmpty() && arr[s.peek()] >= currentElem) {
				
				while(!s.isEmpty() && arr[s.peek()] >= currentElem)
					s.pop();
				
				if(s.isEmpty())
					result[i] = -1;
				else
					result[i] = s.peek();
			}
			
			s.push(i);
			
		}
		return result;
	}


	public static void main(String[] args) {
		System.out.println(find(new int[] {3, 1, 6, 4, 5, 2}));	//(6+4+5)*4 = 60
	}


}
