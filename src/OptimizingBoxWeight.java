import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://aonecode.com/amazon-online-assessment-optimizing-box-weight
//https://leetcode.com/discuss/interview-question/1042645/amazon-oa-storage-optimization-optimizing-box-weight

//similar problem
///https://www.geeksforgeeks.org/smallest-subset-sum-greater-elements/?ref=rp

//Find minimum number of elements such that their sum should be greater than the sum of rest of the elements of the array.

public class OptimizingBoxWeight {
	
	private static List<Integer> findSubset(int[] a) {
		int sum = 0;
		for(int i : a)
			sum += i;
		
		Arrays.sort(a);
		
		List<Integer> result = new ArrayList<Integer>();
		int newSum = 0;
		for(int i=a.length-1;i>0;i--) {
			newSum += a[i];
			result.add(0, a[i]);
			
			if(newSum > (sum/2))
				return result;
		}
		
		return new ArrayList<Integer>();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findSubset(new int[] {5,3,2,4,1,2}));	//{5+4} = 9 > {1+2+2+3} = 8
		System.out.println(findSubset(new int[] {2,3,1,2,4,3}));	//{3+3+4} = 10 > {1+2+2} = 5
	}

}
