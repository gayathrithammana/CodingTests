/**
 * https://leetcode.com/discuss/interview-question/1072308/Amazon-SDE-Coding-Question.-Thought
 * 
 * Oscillating String
 */
public class OscillatingString {
	
	public static String oscillatingString(String s) {
		//freq counter of given string
		int count[] = new int[26];
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			count[c-'a']++;
		}
		
		//traverse 0-26(a-z) 
		StringBuffer ss = new StringBuffer();
		for(int i=0;i<26;i++) {
			if(count[i] > 0) {
				char c = (char)(97 + i);
				ss.append(c);
				count[i]--;
			}
		}
		
		//traverse 26-0(z-a) for the remaining letters
		for(int i=25;i>=0;i--) {
			if(count[i] > 0) {
				char c = (char)(97 + i);
				ss.append(c);
			}
		}
		
		return ss.toString();
		
		
	}

	public static void main(String[] args) {
		System.out.println(oscillatingString("ababyz"));
		System.out.println(oscillatingString("zrta"));
	}

}
