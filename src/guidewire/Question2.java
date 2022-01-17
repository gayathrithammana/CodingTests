package guidewire;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Question2 {

	public int solution(String S) {
		int[] small = new int[26];
		int[] caps = new int[26];

		Arrays.fill(small, 0);
		Arrays.fill(caps, 0);
		
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) >= 65 && S.charAt(i) <= 90)
				caps[S.charAt(i) - 'A']++;
			else
				small[S.charAt(i) - 'a']++;
		}

		Map<Character, Integer> mp = new HashMap<Character, Integer>();

		for (int i = 0; i < 26; i++) {
			if (small[i] != 0 && caps[i] == 0)
				mp.put((char) (i + 'a'), 1);
			else if (caps[i] != 0 && small[i] == 0)
				mp.put((char) (i + 'A'), 1);
		}

		Arrays.fill(small, 0);
		Arrays.fill(caps, 0);

		int i = 0, st = 0;
		int start = -1, end = -1;

		int minm = Integer.MAX_VALUE;

		while (i < S.length()) {
			if (mp.get(S.charAt(i)) != null) {

				while (st < i) {
					if (S.charAt(st) >= 65 && S.charAt(st) <= 90)
						caps[S.charAt(st) - 'A']--;
					else
						small[S.charAt(st) - 'a']--;

					st++;
				}
				i += 1;
				st = i;
			} else {
				if (S.charAt(i) >= 65 && S.charAt(i) <= 90)
					caps[S.charAt(i) - 'A']++;
				else
					small[S.charAt(i) - 'a']++;

				while (true) {
					if (S.charAt(st) >= 65 && S.charAt(st) <= 90 && caps[S.charAt(st) - 'A'] > 1) {
						caps[S.charAt(st) - 'A']--;
						st++;
					} else if (S.charAt(st) >= 97 && S.charAt(st) <= 122 && small[S.charAt(st) - 'a'] > 1) {
						small[S.charAt(st) - 'a']--;
						st++;
					} else
						break;
				}

				if (balanced(small, caps)) {
					if (minm > (i - st + 1)) {
						minm = i - st + 1;
						start = st;
						end = i;
					}
				}
				i += 1;
			}
		}

		if (start == -1 || end == -1)
			return -1;

		else {
			String ans = "";
			for (int j = start; j <= end; j++)
				ans += S.charAt(j);

			return ans.length();
		}
		
	}

	public boolean balanced(int small[], int caps[]) {

// For every character, check if
// there exists uppercase as well
// as lowercase characters
		for (int i = 0; i < 26; i++) {
			if (small[i] != 0 && (caps[i] == 0))
				return false;

			else if ((small[i] == 0) && (caps[i] != 0))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question2 a = new Question2();
		System.out.println(a.solution("azABaabza"));
		System.out.println(a.solution("CATattac"));
		System.out.println(a.solution("Madam"));
		System.out.println(a.solution("TacoCat"));
		
	}

}
