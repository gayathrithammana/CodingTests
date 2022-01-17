package uber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhone {
	
	private static List<String> getCombinations(String digits) {
		
		if(digits == null || digits.length() == 0)
			return Collections.emptyList();
		
		Map<Character, List<Character>> map = new HashMap<>();
		map.put(Character.valueOf('2'), Arrays.asList('a', 'b', 'c'));
		map.put(Character.valueOf('3'), Arrays.asList('d', 'e', 'f'));
		map.put(Character.valueOf('4'), Arrays.asList('g', 'h', 'i'));
		map.put(Character.valueOf('5'), Arrays.asList('j', 'k', 'l'));
		map.put(Character.valueOf('6'), Arrays.asList('m', 'n', 'o'));
		map.put(Character.valueOf('7'), Arrays.asList('p', 'q', 'r', 's'));
		map.put(Character.valueOf('8'), Arrays.asList('t', 'u', 'v'));
		map.put(Character.valueOf('9'), Arrays.asList('w', 'x', 'y', 'z'));
		
		List<String> result = new ArrayList<>();
		solve(digits, 0, "", map, result);
		return result;
	}

	private static void solve(String str, int index, String temp, Map<Character, List<Character>> map,
			List<String> result) {
		if(index == str.length())
			result.add(temp);
		else {
			List<Character> list = map.get(str.charAt(index));
			for(char c : list)
				solve(str, index+1, temp+c, map, result);
		}
	}

	public static void main(String[] args) {
		System.out.println(getCombinations("23"));	//[ad, ae, af, bd, be, bf, cd, ce, cf]
		System.out.println(getCombinations(""));	//[]
		System.out.println(getCombinations("2"));	//[a, b, c]
	}

}
