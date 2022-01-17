/**
 * https://leetcode.com/discuss/interview-question/1079519/Amazon-or-SDE-I-New-Grad-or-USA-or-Reject
 * Leetcode 1328. Break a Palindrome
 * https://leetcode.com/problems/break-a-palindrome/
 *
 */
public class BreakingPalindrome {
	
	private static String breakPalindrome(String palindrome) {
		int n = palindrome.length();
        if(n == 1)
            return "";
        
        char[] c = palindrome.toCharArray();
        
        for(int i=0;i<n/2;i++){
            if(c[i] != 'a'){
                c[i] = 'a';             
                return String.valueOf(c);
            }
            
        }
        
        c[n-1] = 'b';           //if all are a s(ex: "aaaaa", "aabaa")
        return String.valueOf(c);
    }

	public static void main(String[] args) {
		System.out.println(breakPalindrome("abccba"));	//aaccba
		System.out.println(breakPalindrome("aabaa"));	//aabab
	}

}
