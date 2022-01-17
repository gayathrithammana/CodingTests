package guidewire;

import java.util.Arrays;

public class Question2Latest {
	
	private static String findWord(String word) {
		int n = word.length();
		for(int i=2;i<n;i++) {//for each length
			String prefix = word.substring(0, i);
			String suffix = word.substring(i, n);
			
			if(isWordSolution(prefix))
				return prefix;
			else if(isWordSolution(suffix))
				return suffix;
			else 
				return findWord(suffix);
		}
		return "";
	}

	private static boolean isWordSolution(String S) {
		int[] small = new int[26];
		int[] caps = new int[26];

		Arrays.fill(small, 0);
		Arrays.fill(caps, 0);
		
		for (int i = 0; i < S.length(); i++) {
			if (Character.isUpperCase(S.charAt(i)))
				caps[S.charAt(i) - 'A'] = 1;
			else
				small[S.charAt(i) - 'a'] = 1;
		}
		
		for (int i = 0; i < 26; i++) {
			if (small[i] != 0 && (caps[i] == 0))
				return false;

			else if ((small[i] == 0) && (caps[i] != 0))
				return false;
		}
		return true;
		
	}

	public static void main(String[] args) {
		System.out.println(findWord("azABaabza"));	//ABaab
	}

}
