import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://aonecode.com/amazon-online-assessment-storage-optimization
 * https://leetcode.com/discuss/interview-question/1042645/amazon-oa-storage-optimization-optimizing-box-weight
 * 
 * Your company is experimenting with a flexible storage system for their warehouses. 
 * The storage unit consists of a shelving system which is one meter deep with removable vertical and horizontal separators. 
 * When all separators are installed, each storage space is one cubic meter (1' x 1' x 1'). 
 * Determine the volume of the largest space when a series of horizontal and vertical separators are removed.
 * 
 * n = 6, m = 6, h = [4], v = [2]
 * Initial storage unit with n = 6 horizontal and m = 6 vertical separators.
 * After the 4th horizontal and 2nd vertical separators are removed. The maximum storage volume for that unit is 2x2x1 = 4:
 * 
 * This problem is similar to maximum area of cake after h/v cuts
 * Step1: Find all possible separators after removing given separators
 * Step2: Find max diff b/w all the separators
 * Step3: Do step1 and step2 for both horizontally and vertically
 * Step4: hDiff * vDiff
 * 
 * 
 * similar problem:
 * https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
 * Leetcode 1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts 
 */
public class StorageOptimization {
	
	//https://aonecode.com/amazon-online-assessment-storage-optimization
	public static int maxArea(int n, int m, int[] horizontalSeparators, int[] verticalSeparators) {
		Arrays.sort(horizontalSeparators);
		Arrays.sort(verticalSeparators);
		
		//step1: remove above separators and find latest separators
		List<Integer> latestHorizontalSeparators = new ArrayList<Integer>();
		latestHorizontalSeparators.add(0);
		int index = 0;
		for(int i=1;i<n+1;i++) {
			if(index == horizontalSeparators.length || i != horizontalSeparators[index])
				latestHorizontalSeparators.add(i);
			else
				index++;
		}
		latestHorizontalSeparators.add(n+1);
		System.out.println(latestHorizontalSeparators);
		
		//step2: find maxDiff between each separator
		int hDiff = latestHorizontalSeparators.get(0);
		for (int i = 1; i < latestHorizontalSeparators.size(); i++) {
			int diff = latestHorizontalSeparators.get(i) - latestHorizontalSeparators.get(i-1);

			hDiff = Math.max(hDiff, diff);
		}
		
		//step1: remove above separators and find latest separators
		List<Integer> latestVerticalSeparators = new ArrayList<Integer>();
		latestVerticalSeparators.add(0);
		index = 0;
		for(int i=1;i<m+1;i++) {
			if(index == horizontalSeparators.length || i != verticalSeparators[index])
				latestVerticalSeparators.add(i);
			else
				index++;
		}
		latestVerticalSeparators.add(m+1);
		System.out.println(latestVerticalSeparators);
		
		//step2: find maxDiff between each separator
		int vDiff = latestVerticalSeparators.get(0);
		for (int i = 1; i < latestVerticalSeparators.size(); i++) {
			int diff = latestVerticalSeparators.get(i) - latestVerticalSeparators.get(i-1);

			vDiff = Math.max(vDiff, diff);
		}
		
		return hDiff * vDiff;

	}

	// https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
	//https://www.youtube.com/watch?v=vmDXWGI48L8
	public static int maxAreaOfCake(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);

		int hCutMax = horizontalCuts[0];
		for (int i = 1; i < horizontalCuts.length; i++) {
			int diff = horizontalCuts[i] - horizontalCuts[i - 1];

			hCutMax = Math.max(hCutMax, diff);
		}
		if (h > horizontalCuts[horizontalCuts.length - 1]) {
			int diff = h - horizontalCuts[horizontalCuts.length - 1];
			hCutMax = Math.max(hCutMax, diff);
		}

		int vCutMax = verticalCuts[0];
		for (int i = 1; i < verticalCuts.length; i++) {
			int diff = verticalCuts[i] - verticalCuts[i - 1];

			vCutMax = Math.max(vCutMax, diff);
		}
		if (w > verticalCuts[verticalCuts.length - 1]) {
			int diff = w - verticalCuts[verticalCuts.length - 1];
			vCutMax = Math.max(vCutMax, diff);
		}

		return (int) (hCutMax % (1e9 + 7) * vCutMax % (1e9 + 7));

	}

	public static void main(String[] args) {
//		System.out.println(maxAreaOfCake(5, 4, new int[] { 1, 2, 4 }, new int[] { 1, 3 }));
		System.out.println(maxArea(6, 6, new int[] { 4 }, new int[] { 2 }));
		System.out.println(maxArea(3, 3, new int[] { 2 }, new int[] { 2 }));
		System.out.println(maxArea(2, 2, new int[] { 1 }, new int[] { 2 }));
		System.out.println(maxArea(3, 2, new int[] { 1,2,3 }, new int[] { 1,2 }));
	}

}
