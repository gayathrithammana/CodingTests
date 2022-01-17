package microsoft.OA;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/discuss/interview-question/525986/Microsoft-or-OA-2020-or-Return-strings-that-donot-contain-identical-neighbors
 * Consider all words with letters a or b or c
 * Example: aba , not abb
 *
 */

public class NoIdenticalNeighborsInString {

	private static List<String> solve(int n, int k) {
		List<String> res = new ArrayList<>();
		String s = "abc";
		dfs(res, s, n, k, new StringBuilder());
		return res;
	}

	private static void dfs(List<String> res, String s, int n, int k, StringBuilder sb) {
		if(res.size() == k)
			return;
		if(sb.length() == n) {
			res.add(sb.toString());
			return;
		}
		for(int i=0;i<s.length();i++) {
			if(sb.length() == 0 || sb.charAt(sb.length() - 1) != s.charAt(i)) {
				sb.append(s.charAt(i));
				dfs(res, s, n, k, sb);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(solve(2, 4));	//ab, ac, ba, bc
		System.out.println(solve(3, 20));	//aba, abc, aca, acb, bab, bac, bca, bcb, cab, cac, cba, cbc
		System.out.println(solve(5, 6));	//ababa, ababc, abaca, abacb, abcab, abcac
	}

}
