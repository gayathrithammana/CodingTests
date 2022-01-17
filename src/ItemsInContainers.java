/**
 * https://aonecode.com/amazon-online-assessment-items-in-containers
 * https://leetcode.com/discuss/interview-question/1079529/Amazon-Offer-or-Google-Offer
 * 
 * Sliding Window
 */
public class ItemsInContainers {
	
	private static int countInWindow(int start, int end, String s) {
		
		int i = start;
		int totalCount = 0;
		int count = 0;
		boolean startCounting = false;
		
		while(i <= end) {
			if(s.charAt(i) == '|' && !startCounting) {
				startCounting = true;
				i++;
			} else if(s.charAt(i) == '*' && startCounting) {
				count++;
				i++;
			} else if(s.charAt(i) == '|' && startCounting) {
				totalCount += count;
				count = 0;
				i++;
			} else
				i++;
		}
		
		
		return totalCount;
	}
	
	private static int[] count(int[] start, int[] end, String s) {
		int count[] = new int[start.length];
		for(int i=0;i<start.length;i++) {
			count[i] = countInWindow(start[i]-1, end[i]-1, s);
		}
		
		return count;
	}

	public static void main(String[] args) {
		//start and end indices(1 <= startIndices[i] <= endIndices[i] <= n) 
		//1 means actual index = 0
		int[] counter = count(new int[] {1, 1}, new int[] {5, 6}, "|**|*|*");	//2,3
		for(int i : counter)
			System.out.print(i + ",");
		
		System.out.println();
		counter = count(new int[] {1}, new int[] {3}, "*|*|");	//0
		for(int i : counter)
			System.out.print(i + ",");
		
		System.out.println();
		counter = count(new int[] {1}, new int[] {6}, "*|*|*|");	//2
		for(int i : counter)
			System.out.print(i + ",");
	}

}
