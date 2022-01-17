package microsoft;

import java.util.HashSet;
import java.util.Set;

public class F4MinDeletionsUniFreq {

	public static void main(String[] args) {
		System.out.println(minDel("aab"));
		System.out.println(minDel("aaabbbcc"));
		System.out.println(minDel("ceabaacb"));
	}
	
	public static int minDel(String s) {
		int[] count = new int[26];
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			count[ch-'a']++; 
		}
		
		Set<Integer> set = new HashSet<>();
		int res = 0;
		for(int i=0;i<26;i++) {
			int charCount = count[i];
			while(charCount > 0) {
				if(!set.contains(charCount)) {
					set.add(charCount);
					break;
				}
				charCount--;
				res++;
			}
		}
		
		return res;
	}
}
