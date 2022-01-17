package microsoft.OA;

import java.util.HashMap;
import java.util.Map;

public class SumUpto1 {
	public static int gcd(int x,int y){ 
		return (y==0) ? x : gcd(y,x%y); 
	}
	
	public static int solution(int[] A, int[] B) {
	    int result=0, M=1000000007;
	    Map<Long, Integer> map = new HashMap<>();
	    
	    for(int i=0; i<A.length; i++){
	        int valA = A[i];
	        int valB = B[i];
	        
	        if(valA > valB)
	        	continue;
	        
	        int g = gcd(valA, valB);
	        valA = valA/g;
	        valB = valB/g;
	        
	        // fraction=p/q, we need (q-p)/q for the other term
	        long hashKey = (long) (valB - valA) * M + valB;
	        if(map.containsKey(hashKey))
	        	result=(result + map.get(hashKey)) % M;
	        
	        long key = (long) (valA * M + valB);
	        map.put(key, map.getOrDefault(key,0)+1);
	    }
	    return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(new int[] {1,1,2}, new int[] {3,2,3}) == 1);
		System.out.println(solution(new int[] {1,1,1}, new int[] {2,2,2}) == 3);
		System.out.println(solution(new int[] {1,2,3,1,2,12,8,4}, new int[] {5,10,15,2,4,15,10,5}) == 10);
	}

}
