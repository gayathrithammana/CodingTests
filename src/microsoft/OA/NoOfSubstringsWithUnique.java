package microsoft.OA;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/discuss/interview-question/1595274/Microsoft-or-Online-Assessment-or-Questions
 * Q1
 *
 */

public class NoOfSubstringsWithUnique {
	
	public static int minSub(String str) {
		int i = 0;		
		int splits = 1;
		Set<Character> set = new HashSet<Character>();
		char keyI = str.charAt(i);
		set.add(keyI);	
		i++;
		while (i < str.length()) {
			
			keyI = str.charAt(i);
			
			if(set.contains(keyI)) {
				splits++;
				set.clear();
			} 
			else
				set.add(keyI);	
			
			i++;
		}
		
		if(splits > 2)
			splits++;
		
		return splits;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minSub("world"));	//1
		System.out.println(minSub("dddd"));		//4
		System.out.println(minSub("abba"));		//2
		System.out.println(minSub("cycle"));	//2
		System.out.println(minSub("cybybcle"));	//2
		
	}

}
