package microsoft.OA;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/discuss/interview-question/1601268/Microsoft-orOA-orInterview-Questions
 * 
 * Q1
 *
 */

public class MinLettersToMakeStringEqualBlocks {
	
	private static int totalConsecutiveFragment(String s){
	    int len = s.length();
	    if(s.length() <= 1)
	        return 0;
	    
	    int res  = 0;
	    int max = 0;
	    List<Integer> list = new ArrayList<>();
	    
	    int i = 0, j = 0;
	    while(j < len){
	        char ch1 = s.charAt(i);
	        while(j < len && s.charAt(j) == ch1){
	            j++;
	        }
	        int sameLettersCount = j-i;
	        list.add(sameLettersCount);
	        max = Math.max(max, sameLettersCount);
	        i = j;
	    }
	    
	    for(int num : list){
	        res += max-num;
	    }
	    return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
