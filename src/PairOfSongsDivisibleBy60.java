/**
 * https://leetcode.com/discuss/interview-question/1079529/Amazon-Offer-or-Google-Offer
 * Leetcode 1010. Pairs of Songs With Total Durations Divisible by 60
 * 
 * Similar to two sum
 */
public class PairOfSongsDivisibleBy60 {
	
	private static int count(int[] time) {
		int resultCount = 0;
		int count[] = new int[60];
		for(int t:time) {
			resultCount += count[(600 - t) % 60];
			count[t % 60] += 1;
		}
		
		return resultCount;
	}

	public static void main(String[] args) {
		System.out.println(count(new int[] {30,20,150,100,40}));	//3 -> {{30,150}, {20,100}, {20, 40}}
	}

}
