package fangHardBytechlead;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Leetcode 472. Concatenated Words
 * https://leetcode.com/problems/concatenated-words/
 * 
 * https://www.youtube.com/watch?v=QGVCnjXmrNg
 */

public class WordConcatenation {
	
	private static List<String> findWords(String[] words) {
		Set<String> dict = new HashSet<String>();	//for constant time lookup
		for(String word : words)
			dict.add(word);
		
		Map<String, Boolean> cache = new HashMap<String, Boolean>();
		List<String> result = new ArrayList<String>();
		for(String word : words) {
			if(canForm(word, dict, cache))
				result.add(word);
		}
		
		return result;
	}

	private static boolean canForm(String word, Set<String> dict, Map<String, Boolean> cache) {
		if(cache.containsKey(word))
			return cache.get(word);
		
		int n = word.length();
		for(int i=1;i<n;i++) {//for each length
			String prefix = word.substring(0, i);
			String suffix = word.substring(i, n);
			
			if(dict.contains(prefix)) {
				if(dict.contains(suffix) || canForm(suffix, dict, cache)) {
					cache.put(word, true);
					return true;
				}
					
			}
		}
		cache.put(word, false);
		return false;
	}

	public static void main(String[] args) {
		System.out.println(findWords(new String[] {"cat","dog","catdog"}));	//catdog
	}

}
