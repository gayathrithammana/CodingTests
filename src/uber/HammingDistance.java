package uber;

/**
 * https://leetcode.com/problems/hamming-distance/
 * https://www.youtube.com/watch?v=oGU1At1GFvc&list=PLi9RQVmJD2fbR01PY689X9QC2wiz-qVQO
 * 461. Hamming Distance
 * 
 * the number of positions at which the corresponding bits are different.
 */

public class HammingDistance {
	
	private static int findBitsDiffCount(int x, int y) {
		int result = 0;
		
		while(x > 0 || y > 0) {
			result += (x % 2 ) ^ (y % 2);
			x >>= 1;
			y >>= 1;
		}
		return result;
		
//		return Integer.bitCount(x ^ y); 
	}

	public static void main(String[] args) {
		System.out.println(findBitsDiffCount(1, 4));	//2
		System.out.println(findBitsDiffCount(3, 1));	//1
	}

}
