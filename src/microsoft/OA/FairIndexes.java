package microsoft.OA;

/**
 * https://algo.monster/problems/fair_indexes
 *
 */
public class FairIndexes {
	 public static int fairIndex(int a[], int b[]){
		int size = a.length;
		int result = 0;
        int preSumA = 0;
        int preSumB = 0;

        for (int i = 0; i < size; i++) {
            preSumA += a[i];
            preSumB += b[i];
        }
        
        int currentSumA = a[0] + a[1];
        int currentSumB = b[0] + b[1];

        for (int i = 2; i < size; i++) {
            if (currentSumA == currentSumB) {
            	if(preSumA == 2 * currentSumA && preSumB == 2 * currentSumB) {
            		result++;
            	}
            }
            
            currentSumA += a[i];
            currentSumB += b[i];
        }
        return result;
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fairIndex(new int[] {4, -1, 0, 3}, new int[] {-2, 5, 0, 3}));	//2
		System.out.println(fairIndex(new int[] {2, -2, -3, 3}, new int[] {0, 0, 4, -4}));	//1
	}

}
