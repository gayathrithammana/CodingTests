import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/discuss/interview-question/1031663/Amazon-OA
 * https://aonecode.com/oa-shopping-options
 * 
 * Shopping Options
 * Team Expansion
 * Shopper's Delight
 * 
 * https://www.youtube.com/watch?v=AGSRsf19veU
 * https://www.chegg.com/homework-help/questions-and-answers/2-shopper-s-delight-shopaholic-buy-pair-jeans-pair-shoes-skirt-top-budgeted-dollars-given--q58094309
 */

public class ShoppersDelight {
	
	private static int noOfPairs(int[] jeans, int[] shoes, int[] skirts, int[] tops, int budget) {
		Arrays.sort(jeans);
		Arrays.sort(shoes);
		Arrays.sort(skirts);
		Arrays.sort(tops);
		
		int jeansEnd = getEnd(jeans, budget);
		int shoesEnd = getEnd(shoes, budget);
		int skirtsEnd = getEnd(skirts, budget);
		int topsEnd = getEnd(tops, budget);
		
		Map<String, Integer> jeansAndShoesMap = new HashMap<String, Integer>();
		
		for(int i = 0;i < jeansEnd;i++) {
			for(int j = 0;j < shoesEnd;j++) {
				if(jeans[i] + shoes[j] < budget) {
					jeansAndShoesMap.put(i + " " + j, jeans[i] + shoes[j]);
				}
			}
		}
		
		Map<String, Integer> skirtsAndTopsMap = new HashMap<String, Integer>();
		for(int i = 0;i < skirtsEnd;i++) {
			for(int j = 0;j < topsEnd;j++) {
				if(skirts[i] + tops[j] < budget) {
					skirtsAndTopsMap.put(i + " " + j, skirts[i] + tops[j]);
				}
			}
		}
		
		int count = 0;
		for(Map.Entry<String, Integer> jeansAndShoesPair : jeansAndShoesMap.entrySet()) {
			for(Map.Entry<String, Integer> skirtsAndTopsPair : skirtsAndTopsMap.entrySet()) {
				if(jeansAndShoesPair.getValue() + skirtsAndTopsPair.getValue() <= budget) {
					count++;
				}
			}
		}
		
		
		
		return count;
	}

	private static int getEnd(int[] arr, int limit) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i] > limit)
				return i-1;
		}
			
		return arr.length;
	}

	public static void main(String[] args) {
		System.out.println(noOfPairs(new int[] {2,3}, new int[] {4}, new int[] {2,3}, new int[] {1,2}, 10));	//4
		System.out.println(noOfPairs(new int[] {4}, new int[] {3,4,1}, new int[] {2,3}, new int[] {4}, 12));	//2
		System.out.println(noOfPairs(new int[] {2,3}, new int[] {4}, new int[] {2}, new int[] {1,2,3}, 10));	//3
		System.out.println(noOfPairs(new int[] {1}, new int[] {4}, new int[] {3}, new int[] {1}, 3));			//0
		
		System.out.println(noOfPairs(new int[] {2}, new int[] {3,4}, new int[] {2,5}, new int[] {4,6}, 12));	//2
		System.out.println(noOfPairs(new int[] {2}, new int[] {2,2}, new int[] {2}, new int[] {2}, 9));			//2
		System.out.println(noOfPairs(new int[] {4,7}, new int[] {6,6}, new int[] {1,3,5}, new int[] {5,7,12}, 20));	//12
	}

}
